
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
            long sleepTime = windowTimeMillis - (currentTime - requestsInWindow.peek());
            if (sleepTime > 0) {
                System.out.println("Requests are over the max. Sleep time : " + sleepTime);
                Thread.sleep(sleepTime);
            }

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
            // 1 basic function test
            double convertedAmount1 = service.convertCurrency("USD", "EUR", 1000);
            System.out.println("basic funtion test convertedAmount1 : " + convertedAmount1);
            // 2 cache test
            double convertedAmount1_withCache = service.convertCurrency("USD", "EUR", 2000);
            System.out.println("cache test. you will see 'cache hit USD_EUR' convertedAmount1_withCache :" + convertedAmount1_withCache);
            double convertedAmount2 = service.convertCurrency("USD", "JPY", 2000);
            System.out.println("cache test. you will see 'cache not exist for USD_JPY' convertedAmount2" + convertedAmount2);
            // 3 cache expire test
            Thread.sleep(500);
            double convertedAmount1_cacheExpire = service.convertCurrency("USD", "EUR", 3000);
            System.out.println("cache test. you will see 'cache exist but expired: USD_EUR' convertedAmount1_cacheExpire :" + convertedAmount1_cacheExpire);

            //4 high through put test
            for (int i = 0; i < 30; i++) {
                convertedAmount1 = service.convertCurrency("USD", "EUR", 1500);
                Thread.sleep(300);
            }
            System.out.println("you will see 'Requests are over the max' convertedAmount1: " + convertedAmount1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
