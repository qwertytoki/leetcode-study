
import java.util.*;

interface ExchangeRateProvider {

    double getExchangeRate(String fromCurrency, String toCurrency) throws Exception;
}

class APIClientA implements ExchangeRateProvider {

    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        // throws new Exception("make an error for testing fallback");

        System.out.println("APIClientA get rate of " + fromCurrency + "_" + toCurrency);
        return 1.10;
    }
}

class APIClientB implements ExchangeRateProvider {

    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        System.out.println("APIClientB get rate of " + fromCurrency + "_" + toCurrency);
        return 1.20;
    }
}

class FallbackExchangeRateProvider implements ExchangeRateProvider {

    List<ExchangeRateProvider> providers;

    FallbackExchangeRateProvider(List<ExchangeRateProvider> providers) {
        this.providers = providers;
    }

    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        for (ExchangeRateProvider provider : providers) {
            try {
                return provider.getExchangeRate(fromCurrency, toCurrency);
            } catch (Exception e) {
                System.out.println("API failed, try next provider");
            }
        }
        throw new Exception("all providers failed. Please check ASAP!");
    }
}

class CacheManager {

    private class CacheValue {

        double rate;
        long timestamp;

        CacheValue(double rate, long timestamp) {
            this.rate = rate;
            this.timestamp = timestamp;
        }
    }

    private final Map<String, CacheValue> cache;
    private final long windowTimeMillis;

    public CacheManager(long windowTimeMillis) {
        this.windowTimeMillis = windowTimeMillis;
        cache = new HashMap<>();
    }

    public Double getCache(String currencyPair) {
        if (!cache.containsKey(currencyPair)) {
            System.out.println("cache NOT hit!");
            return null;
        }
        CacheValue val = cache.get(currencyPair);
        long currentTime = System.currentTimeMillis();
        if ((currentTime - val.timestamp) > windowTimeMillis) {
            System.out.println("cache NOT hit!");
            return null;
        }
        System.out.println("cache hit!");
        return val.rate;

    }

    public void putCache(String currencyPair, double rate) {
        cache.put(currencyPair, new CacheValue(rate, System.currentTimeMillis()));
    }
}

class CurrencyConvertService {

    private final ExchangeRateProvider provider;
    private final CacheManager cacheManager;

    public CurrencyConvertService(ExchangeRateProvider provider, CacheManager cacheManager) {
        this.provider = provider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.getCache(currencyPair);
        if (rate == null) {
            rate = provider.getExchangeRate(fromCurrency, toCurrency);
            cacheManager.putCache(currencyPair, rate);
        }
        return rate * amount;
    }

}

class Main {

    public static void main(String[] args) {
        List<ExchangeRateProvider> providers = Arrays.asList(new APIClientA(), new APIClientB());
        ExchangeRateProvider exchangeRateProvider = new FallbackExchangeRateProvider(providers);
        CacheManager cacheManager = new CacheManager(60000);

        CurrencyConvertService convertService = new CurrencyConvertService(exchangeRateProvider, cacheManager);
        try {
            double amount1 = convertService.convertCurrency("SGD", "JPY", 100);
            System.out.println("converted amount1 " + amount1);
            double amount2 = convertService.convertCurrency("SGD", "JPY", 200);
            System.out.println("converted amount2 " + amount2);
            double amount3 = convertService.convertCurrency("SGD", "USD", 150);
            System.out.println("converted amount3 " + amount3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
