
import java.util.*;
import java.util.function.Supplier;

enum CircuitBreakerState {
    CLOSED, OPEN, HALF_OPEN
}

class CircuitBreaker<T> {

    private CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private final Supplier<T> function;
    private final int failureThreshold;
    private final long timeoutDuration;
    private final long failureWindow;
    private Queue<Long> failureQueue = new LinkedList<>();
    private long lastFailureTime = 0;

    CircuitBreaker(Supplier<T> function, int failureThreshold, long timeoutDuration, long failureWindow) {
        this.function = function;
        this.failureThreshold = failureThreshold;
        this.timeoutDuration = timeoutDuration;
        this.failureWindow = failureWindow;
    }

    T execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if (currentTime - lastFailureTime > timeoutDuration) {
                state = CircuitBreakerState.HALF_OPEN;
            } else {
                throw new Exception("Service is currently unavailable");
            }
        }
        try {
            T result = function.get();
            reset();
            return result;
        } catch (Exception e) {
            recordFailure(currentTime);
            throw new Exception("Error during execution", e);
        }
    }

    private void reset() {
        failureQueue.clear();
        state = CircuitBreakerState.CLOSED;
    }

    private void recordFailure(long currentTime) {
        while (!failureQueue.isEmpty() && (currentTime - failureQueue.peek()) > failureWindow) {
            failureQueue.poll();
        }
        failureQueue.add(currentTime);
        lastFailureTime = currentTime;
        if (failureQueue.size() >= failureThreshold) {
            state = CircuitBreakerState.OPEN;
        }
    }

}
