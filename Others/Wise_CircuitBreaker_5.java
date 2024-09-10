
import java.util.function.Supplier;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Wise_CircuitBreaker_5 {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            int count;

            @Override
            public String get() {
                count++;
                if (count < 4) {
                    throw new RuntimeException("test error");
                }
                return "hello!";
            }
        };
        CircuitBreaker<String> circuitBreaker = new CircuitBreaker<>(supplier, 3, 3, 2000, 5000);
        for (int i = 0; i < 5; i++) {
            try {
                circuitBreaker.execute(); //state will change to OPEN
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
            System.out.println(circuitBreaker.execute()); //state will change to HALF_OPEN
            System.out.println(circuitBreaker.execute());
            System.out.println(circuitBreaker.execute()); //state will change to CLOSED
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
    private final int failureThreshold;
    private final int halfOpenThreshold;
    private final long timeoutDuration;
    private final long failureWindow;
    private final Queue<Long> failureQueue;
    private int halfOpenSuccessCount = 0;
    private long lastFailureTime = 0;

    public CircuitBreaker(Supplier<T> supplier, int failureThreshold, int halfOpenThreshold,
            long timeoutDuration, long failureWindow) {
        this.supplier = supplier;
        this.failureThreshold = failureThreshold;
        this.halfOpenThreshold = halfOpenThreshold;
        this.timeoutDuration = timeoutDuration;
        this.failureWindow = failureWindow;
        failureQueue = new ConcurrentLinkedQueue<>();

    }

    public T execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if (currentTime - lastFailureTime > timeoutDuration) {
                System.out.println("stae is now HALF_OPEN");
                state = CircuitBreakerState.HALF_OPEN;
                halfOpenSuccessCount = 0;
            } else {
                throw new Exception("State is OPEN, service unavailable.");
            }
        }
        try {
            T result = supplier.get();
            if (state == CircuitBreakerState.HALF_OPEN) {
                System.out.println("halfOpenSuccessCount: " + halfOpenSuccessCount);
                halfOpenSuccessCount++;
                if (halfOpenSuccessCount >= halfOpenThreshold) {
                    reset();
                }

            }
            return result;
        } catch (Exception e) {
            if (state == CircuitBreakerState.HALF_OPEN) {
                state = CircuitBreakerState.OPEN;
                halfOpenSuccessCount = 0;
            } else {
                countFailure(currentTime);
            }
            throw new Exception("error in execute()", e);
        }

    }

    private void countFailure(long currentTime) {
        while (!failureQueue.isEmpty() && (currentTime - failureQueue.peek()) > failureWindow) {
            failureQueue.poll();
        }
        failureQueue.add(currentTime);
        if (failureQueue.size() > failureThreshold) {
            System.out.println("state is now OPEN!");
            state = CircuitBreakerState.OPEN;
            lastFailureTime = currentTime;
        }
    }

    private void reset() {
        System.out.println("state is now closed");
        state = CircuitBreakerState.CLOSED;
        failureQueue.clear();
        lastFailureTime = 0;
        halfOpenSuccessCount = 0;
    }

}
