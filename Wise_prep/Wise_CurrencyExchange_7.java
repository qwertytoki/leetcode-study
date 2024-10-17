
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class Wise_CurrencyExchange_7 {

    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager(3000);
        ConversionRateProvider conversionRateProvider;
        conversionRateProvider = new FallbackExchangeRateProvider(Arrays.asList(new ProviderA(), new ProviderB()));

        CurrencyConversionService service = new CurrencyConversionService(cacheManager, conversionRateProvider);
        try {
            System.out.println(service.convertCurrency("SGD", "JPY", 100)); // cache NOT hit
            System.out.println(service.convertCurrency("SGD", "JPY", 200)); // cache NOT hit

            Thread.sleep(3000);
            System.out.println(service.convertCurrency("SGD", "JPY", 300)); // cache hit but expired
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class CurrencyConversionService {

    private final CacheManager cacheManager;
    private final ConversionRateProvider conversionRateProvider;

    public CurrencyConversionService(CacheManager cacheManager, ConversionRateProvider conversionRateProvider) {
        this.cacheManager = cacheManager;
        this.conversionRateProvider = conversionRateProvider;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.get(currencyPair);
        if (rate == null) {
            rate = conversionRateProvider.getConversionRate(fromCurrency, toCurrency);
            cacheManager.put(currencyPair, rate);
        }
        return rate * amount;
    }

}

class CacheManager {

    class CacheValue {

        double rate;
        long time;

        CacheValue(double rate, long time) {
            this.rate = rate;
            this.time = time;
        }
    }
    Map<String, CacheValue> dict = new ConcurrentHashMap<>();
    long timeToLive;

    public CacheManager(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Double get(String key) {

        if (!dict.containsKey(key)) {
            System.out.println("Cache Not hit!");
            return null;
        }
        CacheValue cacheVal = dict.get(key);
        long currentTime = System.currentTimeMillis();
        if ((currentTime - cacheVal.time) > timeToLive) {
            System.out.println("Cache hit but expired!");
            return null;
        }
        System.out.println("Cache hit!");
        return cacheVal.rate;
    }

    public void put(String key, double value) {
        System.out.println("Cache put! key:" + key);
        dict.put(key, new CacheValue(value, System.currentTimeMillis()));
    }
}

interface ConversionRateProvider {

    double getConversionRate(String fromCurrency, String toCurrency) throws Exception;
}

class ProviderA implements ConversionRateProvider {

    @Override
    public double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        throw new Exception("Provider A fallback test!");
        // return 110.0;
    }
}

class ProviderB implements ConversionRateProvider {

    @Override
    public double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        return 105.0;
    }
}

class FallbackExchangeRateProvider implements ConversionRateProvider {

    List<ConversionRateProvider> providers;

    public FallbackExchangeRateProvider(List<ConversionRateProvider> providers) {
        this.providers = providers;
    }

    @Override
    public double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        for (ConversionRateProvider provider : providers) {
            try {
                return provider.getConversionRate(fromCurrency, toCurrency);
            } catch (Exception e) {
                System.out.println("provider failed to get coversion rate, we will try other providers : " + e.getMessage());
            }
        }
        throw new Exception("all providers failed. ASAP we need to check");
    }
}
