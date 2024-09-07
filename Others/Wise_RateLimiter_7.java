
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Wise_RateLimiter_7 {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(3, 1000);
        for (int i = 1; i <= 30; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("request is alowed : " + i);
            } else {
                System.out.println("request is denied : " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RateLimiter {

    private final int maxCall;
    private final long windowTimeMillis;
    private final Queue<Long> requestsInWindow = new ConcurrentLinkedQueue<>();

    RateLimiter(int maxCall, long windowTimeMillis) {
        this.maxCall = maxCall;
        this.windowTimeMillis = windowTimeMillis;
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > windowTimeMillis) {
            requestsInWindow.poll();
        }
        if (requestsInWindow.size() >= maxCall) {
            return false;
        }
        requestsInWindow.add(currentTime);
        return true;
    }

}
