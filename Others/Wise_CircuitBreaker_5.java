
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;

class Wise_CircuitBreaker_5 {

    public static void main(String args[]) {
        Supplier<String> supplier = new Supplier<String>() {
            int count = 0;

            @Override
            public String get() {
                if (count < 4) {
                    throw new RuntimeException("test error!");
                }
                return "hello!";
            }
        }
        CircuitBreaker<String> circuitBreaker = new CircuitBreaker();

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
    private int failureCount = 0;
    private int halfOpenSuccessCount = 0;
    private long lastFailureTime = 0;
    private final Queue<Long> failureQueue = new ConcurrentLinkedQueue<>();

    public CircuitBreaker(Supplier<T> supplier, int failureThreshold, int halfOpenThreshold, long timeoutDuration, long failureWindow) {
        this.supplier = supplier;
        this.failureThreshold = failureThreshold;
        this.halfOpenThreshold = halfOpenThreshold;
        this.timeoutDuration = timeoutDuration;
        this.failureWindow = failureWindow;
    }

    public T execute() throws Exception 
        long currentTime = System.currentTimeMillis();
        if state == CircuitBreakerState.OPEN){
            if (currentTime - lastFailureTime) > timeoutDuration){
                System.out.println("CircuitBreakerState.HALF_OPEN");
                state = CircuitBreakerState.HALF_OPEN;
                halfOpenSuccessCount = 0;
            }
            lse {
                throw new Exception("CircuitBreakerState is OPEN, service unabvailable.");
            }
        }
        try {
            T result = supplier.get();
            if state == CircuitBreakerState.HALF_OPEN){
                halfOpenSuccessCount++;
                if halfOpenSuccessCount >= halfOpenThreshold){
                    System.out.println("CircuitBreakerState turns to CLOSE");
                    state = CircuitBreakerState.CLOSED;
                    halfOpenSuccessCount = 0;
                }
            }
        } catch (Exception e) {
            if state == CircuitBreakerState.HALF_OPEN){
                System.out.println("CircuitBreakerState turns to OPEN");
                state = CircuitBreakerState.OPEN;
                halfOpenSuccessCount = 0;
            }
            throw new Exception("execute failed!", e);
        }
    }
}
