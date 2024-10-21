
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Wise_RateLimiter_8 {

    public static void main(String args[]) {
        RateLimiter rateLimiter = new RateLimiter(3, 1000);
        for (int i = 0; i < 30; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("request allowed: " + i);
            } else {
                System.out.println("request denied : " + i);
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

    private final int maxSize;
    private final long windowTimeMillis;
    private final Queue<Long> requestsInWindow = new ConcurrentLinkedQueue<>();

    RateLimiter(int maxSize, long windowTimeMillis) {
        this.maxSize = maxSize;
        this.windowTimeMillis = windowTimeMillis;
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > windowTimeMillis) {
            requestsInWindow.poll();
        }
        if (requestsInWindow.size() >= maxSize) {
            return false;
        }
        requestsInWindow.add(currentTime);
        return true;
    }
}
