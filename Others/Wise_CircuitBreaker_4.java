
import java.util.Queue;
import java.util.function.Supplier;

public class Wise_CircuitBreaker_4 {

    public static void main(String[] args) {

    }
}

enum CircuitBreakerState {
    OPEN, HALF_OPEN, CLOSED
}

class CircuitBreaker<T> {

    private CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private final Supplier<T> supplier;
    private int failureThreshold;
    private long timeoutDuration;
    private long failureWindow;
    private long lastFailureTime = 0;
    private Queue<Long> failureQueue;

    CircuitBreaker(Supplier<T> supplier, int failureThreshold, long timeoutDuration, long failureWindow) {
        this.supplier = supplier;
        this.failureThreshold = failureThreshold;
        this.timeoutDuration = timeoutDuration;
        this.failureWindow = failureWindow;
    }

    public T execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if ((currentTime - lastFailureTime) > timeoutDuration) {
                state = CircuitBreakerState.HALF_OPEN;
            }
        } else {
            throw new Exception("circuit breaker is ON, service unavailable now");
        }
        try {
            T result = supplier.get();
            reset();
            return result;
        } catch (Exception e) {
            countFailure(currentTime);
            throw new Exception("failure in execute()");
        }
    }

    private void reset() {
        state = CircuitBreakerState.CLOSED;
        failureQueue.clear();
    }

    private void countFailure(long currentTime) {

        while (!failureQueue.isEmpty() && (currentTime - failureQueue.peek()) > failureWindow) {
            failureQueue.poll();
        }
        failureQueue.add(currentTime);
        lastFailureTime = currentTime;
        if (failureQueue.size() > failureThreshold) {
            state = CircuitBreakerState.OPEN;
        }
    }
}
