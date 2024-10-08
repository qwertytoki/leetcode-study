
import java.util.*;
import java.util.function.Supplier;

public class Wise_CircuitBreaker_3 {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            private int count = 0;

            @Override
            public String get() {
                count++;
                if (count < 4) {
                    throw new RuntimeException("Test error");
                } else {
                    return "Supplier returns a value";
                }
            }
        };

        CircuitBreaker<String> circuitBreaker = new CircuitBreaker<>(supplier, 3, 2000, 5000);
        for (int i = 0; i < 30; i++) {
            try {
                circuitBreaker.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            circuitBreaker.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Thread.sleep(3000);
            System.out.println(circuitBreaker.execute());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

enum CircuitBreakerState {
    OPEN, HALF_OPEN, CLOSED
}

class CircuitBreaker<T> {

    private CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private Supplier<T> supplier;
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
                throw new Exception("Circuit Breaker is ON. Service temporarily unavailable.");
            }
        }
        try {
            T result = supplier.get();
            reset();
            return result;
        } catch (Exception e) {
            collectFailure(currentTime);
            throw new Exception("Error during execution", e);
        }
    }

    private void reset() {
        failureQueue.clear();
        state = CircuitBreakerState.CLOSED;
    }

    private void collectFailure(long currentTime) {
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
