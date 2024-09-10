
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Wise_RateLimiter_10 {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(3, 1000);
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

    int maxRequests;
    long requestWindowMillis;
    Queue<Long> requestsInWindow = new ConcurrentLinkedQueue<>();

    public RateLimiter(int maxRequests, long requestWindowMillis) {
        this.maxRequests = maxRequests;
        this.requestWindowMillis = requestWindowMillis;
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > requestWindowMillis) {
            requestsInWindow.poll();
        }
        if (requestsInWindow.size() >= maxRequests) {
            return false;
        }
        requestsInWindow.add(currentTime);
        return true;
    }
}
