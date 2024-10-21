
import java.util.*;

class ExchangeRateProvider {

    public double getCurrencyRate(String fromCurrency, String toCurrency) {
        return 1.0;
    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int maxSize;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}

class CacheManager {

    private class CacheValue {

        long time;
        double rate;

        CacheValue(long time, double rate) {
            this.time = time;
            this.rate = rate;
        }
    }

    private final Map<String, CacheValue> cache;
    private final long windowTimeMillis;

    CacheManager(int maxCacheSize, long windowTimeMillis) {
        this.windowTimeMillis = windowTimeMillis;
        cache = new LRUCache<>(maxCacheSize);
    }

    public Double getCache(String currencyPair) {
        CacheValue val = cache.get(currencyPair);
        if (val == null) {
            System.out.println("Cache not hit!");
            return null;
        }
        long currentTime = System.currentTimeMillis();
        if ((currentTime - val.time) > windowTimeMillis) {
            System.out.println("Cache hit, but expired");
            return null;
        }
        System.out.println("Cache hit!");
        return val.rate;
    }

    public void putCache(String currencyPair, double rate) {
        cache.put(currencyPair, new CacheValue(System.currentTimeMillis(), rate));
    }

}

class CurrencyConvertService {

    ExchangeRateProvider rateProvider;
    CacheManager cacheManager;

    CurrencyConvertService(ExchangeRateProvider rateProvider, CacheManager cacheManager) {
        this.rateProvider = rateProvider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.get(currencyPair);
        if (rate == null) {
            rate = rateProvider.getCurrencyRate(fromCurrency, toCurrency);
            cacheManager.putCache(currencyPair, rate);
        }
        return rate * amount;
    }
}

class Main {

    public static void main(String[] args) {
        ExchangeRateProvider rateProvider = new ExchangeRateProvider();
        CacheManager cacheManager = new CacheManager(10, 5000);
        CurrencyConvertService service = new CurrencyConvertService(rateProvider, cacheManager);

        try {
            double amount1 = service.convertCurrency("SGD", "JPY", 1000);
            System.out.println("amount1: " + amount1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
