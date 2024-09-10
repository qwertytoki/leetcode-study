
public class Wise_CircuitBreaker_6 {

    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker(3, 2, 2000);

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(circuitBreaker.execute()); // failure 3 times, then Circuit breaker will OPEN
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Thread.sleep(3000);
            System.out.println(circuitBreaker.execute()); // HALF_OPEN 1
            System.out.println(circuitBreaker.execute()); // HALF_OPEN 2 -> back to CLOSED
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class CircuitBreaker {

    CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private final int failureThreshold;
    private final int halfOpenThreshold;
    private final long timeoutDuration;
    private int count = 0;
    private int failureCount = 0;
    private int halfOpenSuccessCount = 0;
    private long lastFailureTime;

    CircuitBreaker(int failureThreshold, int halfOpenThreshold, long timeoutDuration) {
        this.failureThreshold = failureThreshold;
        this.halfOpenThreshold = halfOpenThreshold;
        this.timeoutDuration = timeoutDuration;
    }

    public String execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if ((currentTime - lastFailureTime) > timeoutDuration) {
                System.out.println("state OPEN -> HALF_OPEN");
                state = CircuitBreakerState.HALF_OPEN;
                halfOpenSuccessCount = 0;
            } else {
                throw new Exception("state is OPEN, service unavailable");
            }
        }
        try {
            count++;
            if (count < 4) {
                throw new Exception("test failure!");
            }
            if (state == CircuitBreakerState.HALF_OPEN) {
                halfOpenSuccessCount++;
                if (halfOpenSuccessCount >= halfOpenThreshold) {
                    reset();
                }
            }
            return "HELLO!";
        } catch (Exception e) {
            countFailure(currentTime);
            throw new Exception("execute() failed", e);

        }
    }

    private void reset() {
        System.out.println("state HALF_OPEN -> CLOSED");
        state = CircuitBreakerState.CLOSED;
        halfOpenSuccessCount = 0;
        failureCount = 0;
        lastFailureTime = 0;
    }

    private void countFailure(long currentTime) {
        lastFailureTime = currentTime;
        failureCount++;
        if (failureCount >= failureThreshold) {
            System.out.println("state CLOSED -> OPEN");
            state = CircuitBreakerState.OPEN;
            halfOpenSuccessCount = 0;
        }

    }

    enum CircuitBreakerState {
        OPEN, HALF_OPEN, CLOSED
    }
}
