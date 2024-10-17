
class Wise_CircuitBreaker_7 {

    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker(3, 2, 2000);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(circuitBreaker.execute());   //first 3 will be failed, and state will OPEN
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            System.out.println("Thread.sleep(2001)");
            Thread.sleep(2001); // over timeoutDuration
            System.out.println(circuitBreaker.execute()); //state will OPEN -> HALF_OPEN
            System.out.println(circuitBreaker.execute()); // state will HALF_OPEN -> CLOSED
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class CircuitBreaker {

    private CircuitBreakerState state = CircuitBreakerState.CLOSED;
    int failureThreshold;
    int halfOpenSuccessThreshold;
    long timeoutDuration;
    int failureCount = 0;
    int halfOpenSuccessCount = 0;
    long lastFailureTime;
    int count = 0;

    public CircuitBreaker(int failureThreshold, int halfOpenSuccessThreshold, long timeoutDuration) {
        this.failureThreshold = failureThreshold;
        this.halfOpenSuccessThreshold = halfOpenSuccessThreshold;
        this.timeoutDuration = timeoutDuration;
    }

    public String execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (state == CircuitBreakerState.OPEN) {
            if ((currentTime - lastFailureTime) > timeoutDuration) {
                System.out.println("State OPEN -> HALF_OPEN");
                state = CircuitBreakerState.HALF_OPEN;
                halfOpenSuccessCount = 0;
            } else {
                throw new Exception("State is OPEN. Service unavailable.");
            }
        }
        try {
            count++;
            if (count < 4) {
                throw new Exception("execute failure test");
            }
            if (state == CircuitBreakerState.HALF_OPEN) {
                halfOpenSuccessCount++;
                if (halfOpenSuccessCount >= halfOpenSuccessThreshold) {
                    reset();
                }

            }
            return "execute success!";
        } catch (Exception e) {
            countFailure(currentTime);
            throw new Exception("execute failed", e);

        }

    }

    private void reset() {
        System.out.println("state HALF_OPEN -> CLOSE");
        state = CircuitBreakerState.CLOSED;
        halfOpenSuccessCount = 0;
        failureCount = 0;
    }

    private void countFailure(long currentTime) {
        failureCount++;
        lastFailureTime = currentTime;
        if (failureCount >= failureThreshold) {
            System.out.println("state CLOSED -> OPEN");
            state = CircuitBreakerState.OPEN;
            halfOpenSuccessCount = 0;
            failureCount = 0;
        }
    }

}

enum CircuitBreakerState {
    OPEN, HALF_OPEN, CLOSED
}
