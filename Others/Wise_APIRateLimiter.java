import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class RateLimiter {
    private final int maxRequests;
    private final long timeWindowMillis;
    private final Map<String, Long> requestCounts;
    private final Map<String, Long> lastResetTime;

    public RateLimiter(int maxRequests, long timeWindowMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
        this.requestCounts = new HashMap<>();
        this.lastResetTime = new HashMap<>();
    }

    public synchronized boolean allowRequest(String apiKey) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastResetTime.getOrDefault(apiKey, 0L) > timeWindowMillis) {
            requestCounts.put(apiKey, 0L);
            lastResetTime.put(apiKey, currentTime);
        }

        long currentCount = requestCounts.getOrDefault(apiKey, 0L);
        if (currentCount < maxRequests) {
            requestCounts.put(apiKey, currentCount + 1);
            return true;
        } else {
            return false;
        }
    }
}

class APIClient {
    private final String apiKey;
    private final RateLimiter rateLimiter;

    public APIClient(String apiKey, RateLimiter rateLimiter) {
        this.apiKey = apiKey;
        this.rateLimiter = rateLimiter;
    }

    public String fetchData() throws InterruptedException {
        if (!rateLimiter.allowRequest(apiKey)) {
            System.out.println("Rate limit exceeded for API key: " + apiKey + ". Retrying after delay...");
            TimeUnit.SECONDS.sleep(1);
            return fetchData();
        }

        // Simulate fetching data from an external API
        System.out.println("Fetching data from API with key: " + apiKey);
        return "Data from API key: " + apiKey;
    }
}

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 10000);  // 10秒間に最大5リクエスト
        APIClient apiClient1 = new APIClient("API_KEY_1", rateLimiter);
        APIClient apiClient2 = new APIClient("API_KEY_2", rateLimiter);

        for (int i = 0; i < 10; i++) {
            try {
                String data1 = apiClient1.fetchData();
                System.out.println(data1);

                String data2 = apiClient2.fetchData();
                System.out.println(data2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}