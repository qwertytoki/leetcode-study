
import java.util.*;

class CurrencyConversionService {

    RateLimiter rateLimiter;
    CacheManager cacheManager;
    RateProvider rateProvider;

    CurrencyConversionService(RateLimiter rateLimiter, CacheManager cacheManager, RateProvider rateProvider) {
        this.rateLimiter = rateLimiter;
        this.cacheManager = cacheManager;
        this.rateProvider = rateProvider;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        rateLimiter.acquire();
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.get(currencyPair);
        if (rate == null) {
            rate = rateProvider.getCurrencyRate(fromCurrency, toCurrency);
            cacheManager.add(currencyPair, rate);
        }
        return rate * amount;
    }
}

class RateLimiter {

    int maxRequests;
    long windowTimeMillis;
    Queue<Long> requestsInWindow;

    RateLimiter(int maxRequests, long windowTimeMillis) {
        this.maxRequests = maxRequests;
        this.windowTimeMillis = windowTimeMillis;
        requestsInWindow = new LinkedList<>();
    }

    public void acquire() throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        while (!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > windowTimeMillis) {
            requestsInWindow.poll();
        }
        if (requestsInWindow.size() > maxRequests) {
            System.out.println("Over max requests, sleep 1 second.");
            Thread.sleep(100);
            acquire();
        }
        System.out.println("now we are good to go!");
        requestsInWindow.add(currentTime);
    }
}

class CacheManager {

    class CacheValue {

        long time;
        double rate;

        CacheValue(long time, double rate) {
            this.time = time;
            this.rate = rate;
        }

    }
    private final Map<String, CacheValue> cache;
    private final long windowTimeMillis;

    CacheManager(long windowTimeMillis) {
        this.windowTimeMillis = windowTimeMillis;
        this.cache = new HashMap<>();
    }

    public void add(String currencyPair, double rate) {
        long currentTime = System.currentTimeMillis();
        cache.put(currencyPair, new CacheValue(currentTime, rate));
    }

    public Double get(String currencyPair) {

        if (!cache.containsKey(currencyPair)) {
            System.out.println("cache not exist for: " + currencyPair);
            return null;
        }
        long currentTime = System.currentTimeMillis();
        CacheValue cacheVal = cache.get(currencyPair);
        if ((currentTime - cacheVal.time) > windowTimeMillis) {
            System.out.println("cache exist but expired: " + currencyPair);
        }
        System.out.println("cache hit: " + currencyPair);
        return cacheVal.rate;
    }
}

class RateProvider {

    public double getCurrencyRate(String from, String to) {
        // hardcoded value. it will call rate provider's API actually.
        return 150.0;
    }
}

class Main {

    public static void main(String args[]) {
        RateProvider rateProvider = new RateProvider();
        CacheManager cacheManager = new CacheManager(500); // set TTL as 5 second for testing.
        RateLimiter rateLimiter = new RateLimiter(3, 1000);

        CurrencyConversionService service = new CurrencyConversionService(rateLimiter, cacheManager, rateProvider);
        try {
            double convertedAmount1 = service.convertCurrency("USD", "EUR", 1000);
            System.out.println(convertedAmount1);

            double convertedAmount2 = service.convertCurrency("USD", "JPY", 2000);
            System.out.println(convertedAmount2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
