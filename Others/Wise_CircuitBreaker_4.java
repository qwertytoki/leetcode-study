
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class Wise_CircuitBreaker_4 {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            int count = 0;

            @Override
            public String get() {
                count++;
                if (count < 4) {
                    throw new RuntimeException("test error");
                }
                return "hello!";
            }
        };

        CircuitBreaker<String> circuitBreaker = new CircuitBreaker<>(supplier, 3, 2000, 5000, 3);
        for (int i = 0; i < 5; i++) {
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
    private final Supplier<T> supplier;
    private int failureThreshold;
    private long timeoutDuration;
    private long failureWindow;
    private long lastFailureTime = 0;
    private Queue<Long> failureQueue = new LinkedList<>();
    private int halfOpenSuccessThreshold;
    private int halfOpenSuccessCount = 0;

    CircuitBreaker(Supplier<T> supplier, int failureThreshold, long timeoutDuration, long failureWindow, int halfOpenSuccessThreshold) {
        this.supplier = supplier;
        this.failureThreshold = failureThreshold;
        this.timeoutDuration = timeoutDuration;
        this.failureWindow = failureWindow;
        this.halfOpenSuccessThreshold = halfOpenSuccessThreshold;
    }

    public T execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if ((currentTime - lastFailureTime) > timeoutDuration) {
                System.out.println("HALF_OPEN");
                state = CircuitBreakerState.HALF_OPEN;
                halfOpenSuccessCount = 0;
            } else {
                throw new Exception("circuit breaker is ON, service unavailable now");
            }
        }
        try {
            T result = supplier.get();
            if (state == CircuitBreakerState.HALF_OPEN) {
                halfOpenSuccessCount++;
                System.out.println("halfOpenSuccessCount: " + halfOpenSuccessCount);
                if (halfOpenSuccessCount >= halfOpenSuccessThreshold) {
                    reset();
                }
            }
            return result;
        } catch (Exception e) {
            if (state == CircuitBreakerState.HALF_OPEN) {
                System.out.println("State becomes OPEN because it was HALF_OPEN and failed");
                state = CircuitBreakerState.OPEN;
                halfOpenSuccessCount = 0;
            } else {
                countFailure(currentTime);
            }
            throw new Exception("failure in execute()", e);

        }
    }

    private void reset() {
        System.out.println("CircuitBreakerState.CLOSED");
        state = CircuitBreakerState.CLOSED;
        failureQueue.clear();
        halfOpenSuccessCount = 0;
        lastFailureTime = 0;
    }

    private void countFailure(long currentTime) {

        while (!failureQueue.isEmpty() && (currentTime - failureQueue.peek()) > failureWindow) {
            failureQueue.poll();
        }
        failureQueue.add(currentTime);
        lastFailureTime = currentTime;
        if (failureQueue.size() >= failureThreshold) {
            System.out.println("CircuitBreakerState.OPEN");
            state = CircuitBreakerState.OPEN;
        }
    }
}
