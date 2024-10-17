
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Wise_CurrencyExchange_6 {

    public static void main(String[] args) {
        ConversionRateProvider provider = new FallbackExchangeProvider(Arrays.asList(new RateProviderA(), new RateProviderB()));
        CacheManager cacheManager = new CacheManager(3);
        CurrencyConversionService service = new CurrencyConversionService(provider, cacheManager);

        try {
            double amount1 = service.convertCurrency("SGD", "JPY", 100);
            System.out.println("amount1 :" + amount1); // cache NOT hit

            double amount2 = service.convertCurrency("SGD", "JPY", 200);
            System.out.println("amount2 :" + amount2); // cache hit

            double amount3 = service.convertCurrency("AUD", "JPY", 300);
            System.out.println("amount3 :" + amount3); // cache NOT hit

            double amount4 = service.convertCurrency("USD", "JPY", 400);
            System.out.println("amount4 :" + amount4); // cache NOT hit

            double amount5 = service.convertCurrency("GBP", "JPY", 500);
            System.out.println("amount5 :" + amount5); // cache NOT hit

            double amount6 = service.convertCurrency("SGD", "JPY", 600);
            System.out.println("amount6 :" + amount6); // cache NOT hit

            double amount7 = service.convertCurrency("USD", "JPY", 700);
            System.out.println("amount7 :" + amount7); // cache hit!

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CurrencyConversionService {

    ConversionRateProvider provider;
    CacheManager cacheManager;

    public CurrencyConversionService(ConversionRateProvider provider, CacheManager cacheManager) {
        this.provider = provider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double currencyRate = cacheManager.get(currencyPair);
        if (currencyRate == null) {
            currencyRate = provider.getCurrencyRate(fromCurrency, toCurrency);
            cacheManager.put(currencyPair, currencyRate);
        }
        return amount * currencyRate;
    }
}

interface ConversionRateProvider {

    double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception;
}

class RateProviderA implements ConversionRateProvider {

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        throw new Exception("test error! ProviderA gets an error!");
        // return 110.0;
    }
}

class RateProviderB implements ConversionRateProvider {

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        // throw new Exception("test error! ProviderB gets an error!");
        return 105.0;
    }
}

class FallbackExchangeProvider implements ConversionRateProvider {

    private final List<ConversionRateProvider> providers;

    public FallbackExchangeProvider(List<ConversionRateProvider> providers) {
        this.providers = providers;
    }

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        for (ConversionRateProvider provider : providers) {
            try {
                return provider.getCurrencyRate(fromCurrency, toCurrency);
            } catch (Exception e) {
                System.out.println("provider faces an error. we will try other providers  " + e.getMessage());
            }
        }

        throw new Exception("all providers are failed. currently we cannot provide currency rate");

    }
}

class CacheManager {

    private class CacheVal {

        private final long time;
        private final double rate;

        CacheVal(long time, double rate) {
            this.time = time;
            this.rate = rate;
        }
    }

    private final Map<String, CacheVal> cache = new ConcurrentHashMap<>();
    private final long timeToLive;

    public CacheManager(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Double get(String currencyPair) {
        if (!cache.containsKey(currencyPair)) {
            System.out.println("cahce not hit!");
            return null;
        }
        long currentTime = System.currentTimeMillis();
        CacheVal val = cache.get(currencyPair);
        if ((currentTime - val.time) > timeToLive) {
            System.out.println("cache hit but expired!");
            cache.remove(currencyPair);
            return null;
        }
        System.out.println("cache hit!");
        return val.rate;
    }

    public void put(String currencyPair, double rate) {
        cache.put(currencyPair, new CacheVal(System.currentTimeMillis(), rate));
    }

}

// class CacheManager extends LinkedHashMap<String, Double> {
//     int maxSize;
//     public CacheManager(int maxSize) {
//         super(maxSize, 0.75f, true);
//         this.maxSize = maxSize;
//     }
//     @Override
//     protected boolean removeEldestEntry(Map.Entry<String, Double> entry) {
//         return size() > maxSize;
//     }
//     public Double get(String currencyPair) {
//         if (!super.containsKey(currencyPair)) {
//             System.out.println("Cache NOT hit!");
//             return null;
//         }
//         System.out.println("Cache hit!");
//         return super.get(currencyPair);
//     }
//     public void put(String currencyPair, double rate) {
//         super.put(currencyPair, rate);
//     }

// }
