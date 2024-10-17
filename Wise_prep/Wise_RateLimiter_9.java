
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class Wise_RateLimiter_9 {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 1000);
        for (int i = 1; i <= 30; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("request is allowed : " + i);
            } else {
                System.out.println("request is denied : " + i);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class RateLimiter {

    private final int maxRequests;
    private final long windowTimeMillis;
    private final Queue<Long> requestsInWindow = new ConcurrentLinkedQueue<>();

    public RateLimiter(int maxRequests, long windowTimeMillis) {
        this.maxRequests = maxRequests;
        this.windowTimeMillis = windowTimeMillis;

    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > windowTimeMillis) {
            requestsInWindow.poll();
        }

        if (requestsInWindow.size() >= maxRequests) {
            return false;
        }
        requestsInWindow.add(currentTime);
        return true;

    }

}
