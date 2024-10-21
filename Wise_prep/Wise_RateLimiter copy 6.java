
import java.util.*;

public class RateLimiter {

    private final int maxRequests;
    private final long windowTimeMillis = 6000;
    private final Map<String, Queue<Long>> requestsInWindowByClient;

    public RateLimiter(int maxRequests) {
        this.maxRequests = maxRequests;
        requestsInWindowByClient = new HashMap<>();
    }

    public synchronized boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        if (!requestsInWindowByClient.containsKey(clientId)) {
            Queue<Long> requestsInWindow = new LinkedList<>();
            requestsInWindow.add(currentTime);
            requestsInWindowByClient.put(clientId, requestsInWindow);
            System.out.println("Return true, requestsInWindowByClient doesn't contain clientId: " + clientId);
            return true;
        }
        Queue<Long> requestsInWindow = requestsInWindowByClient.get(clientId);
        while (currentTime - requestsInWindow.peek() > windowTimeMillis) {
            requestsInWindow.poll();
        }
        if (requestsInWindow.size() < maxRequests) {
            requestsInWindow.add(currentTime);
            requestsInWindowByClient.put(clientId, requestsInWindow);
            return true;
        }
        System.out.println("Requests over the max. It needs some time to call another request.");
        return false;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5);
        System.out.println(rateLimiter.allowRequest("client1")); // true
        System.out.println(rateLimiter.allowRequest("client1")); // true
        System.out.println(rateLimiter.allowRequest("client1")); // true
        System.out.println(rateLimiter.allowRequest("client1")); // true
        System.out.println(rateLimiter.allowRequest("client1")); // true
        System.out.println(rateLimiter.allowRequest("client1")); // false (limit reached)
        System.out.println(rateLimiter.allowRequest("client2")); // true
        System.out.println(rateLimiter.allowRequest("client2")); // true
        System.out.println(rateLimiter.allowRequest("client2")); // true
        System.out.println(rateLimiter.allowRequest("client2")); // true
        System.out.println(rateLimiter.allowRequest("client2")); // true
        System.out.println(rateLimiter.allowRequest("client2")); // false (limit reached)
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(rateLimiter.allowRequest("client1")); // true
        System.out.println(rateLimiter.allowRequest("client2")); // true
    }
}
