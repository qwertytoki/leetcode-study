
import java.util.*;
import java.util.function.Supplier;

public class Wise_CircuitBreaker_1 {

    public static void main(String args[]) {
        Supplier<String> testFunction = new Supplier<String>() {
            private int count = 0;

            @Override
            public String get() {
                count++;
                if (count < 4) {
                    throw new RuntimeException("test error");
                } else {
                    return "hello!";
                }
            }
        };

        CircuitBreaker<String> circuitBreaker = new CircuitBreaker<>(testFunction, 3, 2000, 5000);

        for (int i = 0; i < 3; i++) {
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
    CLOSED, HALF_OPEN, OPEN
}

class CircuitBreaker<T> {

    private CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private final Supplier<T> function;
    private final int failureThreshold;
    private final long timeoutDuration;
    private final long failureWindow;
    private final Queue<Long> failureQueue = new LinkedList<>();
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
                System.out.println("Circuit breaker is now half-open");
                state = CircuitBreakerState.HALF_OPEN;
            } else {
                System.out.println("Circuit breaker is ON!");
                throw new Exception("Service is currently unavailable");
            }
        }
        try {
            T result = function.get();
            reset();
            return result;

        } catch (Exception e) {
            recordFailure(currentTime);
            throw new Exception("Error during execute()");
        }
    }

    private void reset() {
        System.out.println("Now circuit breake is OFF!");
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
