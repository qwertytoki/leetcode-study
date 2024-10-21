
import java.util.*;
import java.util.function.Supplier;

public class Wise_CircuitBreaker_2 {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            private int count = 0;

            @Override
            public String get() {
                count++;

                if (count < 4) {
                    throw new Exception("operation gets an error!");
                } else {
                    return "Supplier returns a value";
                }
            }
        };

        CircuitBreaker<String> circuitBreaker = new CircuitBreaker(supplier, 3, 3000, 5000);
    }
}

enum CircuitBreakerState {
    OPEN, HALF_OPEN, CLOSE
}

class CircuitBreaker<T> {

    private CircuitBreakerState state = CircuitBreakerState.CLOSE;
    private final Supplier<T> supplier;
    private final int failureThreshold;
    private final long timeoutDuration;
    private final long failureWindow;
    private final Queue<Long> failureQueue = new LinkedList<>();
    private long lastFailureTime = 0;

    CircuitBreaker(Supplier<T> supplier, int failureThreshold, long timeoutDuration, long failureWindow) {
        this.supplier = supplier;
        this.failureThreshold = failureThreshold;
        this.timeoutDuration = timeoutDuration;
        this.failureWindow = failureWindow;
    }

    T execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if ((currentTime - lastFailureTime) > timeoutDuration) {
                state = CircuitBreakerState.HALF_OPEN;
            } else {
                throw new Exception("Circuit Breaker is ON! now service unavailable");
            }
        }
        try {
            T result = supplier.get();
            reset();
            return result;
        } catch (Exception e) {
            countFailure(currentTime);
            throw new Exception("execution failed!", e);
        }

    }

    private void reset() {
        state = CircuitBreakerState.CLOSE;
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
