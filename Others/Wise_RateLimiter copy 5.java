
import java.util.*;

class RateLimiter {

    int maxRequests;
    long windowTimeMillis;
    Queue<Long> requestsInWindow;

    RateLimiter(int maxRequests, long windowTimeMillis) {
        this.maxRequests = maxRequests;
        this.windowTimeMillis = windowTimeMillis;
        requestsInWindow = new LinkedList<>();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > windowTimeMillis) {
            requestsInWindow.poll();
        }
        if (requestsInWindow.size() < maxRequests) {
            requestsInWindow.add(currentTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(3, 1000);
        for (int i = 0; i < 30; i++) {

            if (rateLimiter.allowRequest()) {
                System.out.println("request passed: " + i);
            } else {
                System.out.println("request failed: " + i);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
