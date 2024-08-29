
import java.util.*;

interface RateProvider {

    double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception;
}

class ClientA implements RateProvider {

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        // throw new Exception("for test of fall back");
        return 110.0;
    }
}

class ClientB implements RateProvider {

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        // throw new Exception("for test of fall back")
        return 115.0;
    }
}

class FallbackExchangeProvider implements RateProvider {

    List<RateProvider> providers;

    FallbackExchangeProvider(List<RateProvider> providers) {
        this.providers = providers;
    }

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrecy) throws Exception {
        for (RateProvider provider : providers) {
            try {
                return provider.getCurrencyRate(fromCurrency, toCurrecy);
            } catch (Exception e) {
                System.out.println("Error happend! We will try next provider.");
            }
        }
        throw new Exception("all providers are failed. Check the network ASAP!");
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

    long windowTimeMillis;
    Map<String, CacheValue> cache;

    CacheManager(long windowTimeMillis) {
        this.windowTimeMillis = windowTimeMillis;
        cache = new HashMap<>();
    }

    public void add(String currencyPair, double rate) {
        long currentTime = System.currentTimeMillis();
        cache.put(currencyPair, new CacheValue(currentTime, rate));
    }

    public Double get(String currencyPair) {
        long currentTime = System.currentTimeMillis();
        if (!cache.containsKey(currencyPair)) {
            System.out.println("Cache not hit");
            return null;
        }
        CacheValue cacheValue = cache.get(currencyPair);
        if ((currentTime - cacheValue.time) > windowTimeMillis) {
            System.out.println("Cache hit but expired");
            return null;
        }
        return cacheValue.rate;
    }

}

class CurrencyConvertService {

    RateProvider rateProvider;
    CacheManager cacheManager;

    CurrencyConvertService(RateProvider rateProvider, CacheManager cacheManager) {
        this.rateProvider = rateProvider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.get(currencyPair);
        if (rate == null) {
            rate = rateProvider.getCurrencyRate(fromCurrency, toCurrency);
            cacheManager.add(currencyPair, rate);
        }
        return rate * amount;
    }
}

class Main {

    public static void main(String[] args) {
        List<RateProvider> providers = Arrays.asList(new ClientA(), new ClientB());
        RateProvider rateProvider = new FallbackExchangeProvider(providers);
        CacheManager cacheManager = new CacheManager(60000);
        CurrencyConvertService currencyConvertService = new CurrencyConvertService(rateProvider, cacheManager);
        try {
            double convertedAmount1 = currencyConvertService.convertCurrency("SGD", "JPY", 1000);
            System.out.println("convertedAmount1' value : " + convertedAmount1);
            double convertedAmount2 = currencyConvertService.convertCurrency("SGD", "JPY", 2000);
            System.out.println("convertedAmount2' value : " + convertedAmount2);
            double convertedAmount3 = currencyConvertService.convertCurrency("SGD", "USD", 1500);
            System.out.println("convertedAmount3' value : " + convertedAmount3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
