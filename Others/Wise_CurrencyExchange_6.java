
import java.util.LinkedHashMap;
import java.util.Map;

class Wise_CurrencyExchange_6 {

    public static void main(String[] args) {
        ConversionRateProvider provider = new ConversionRateProvider();
        CacheManager cacheManager = new CacheManager(3);
        CurrencyConversionService service = new CurrencyConversionService(provider, cacheManager);
        double amount1 = service.convertCurrency("SGD", "JPY", 100);
        System.out.println("amount1 :" + amount1); // cache NOT hit

        double amount2 = service.convertCurrency("SGD", "JPY", 200);
        System.out.println("amount2 :" + amount2); // cache hit

        double amount3 = service.convertCurrency("AUD", "JPY", 300);
        System.out.println("amount1 :" + amount3); // cache NOT hit

        double amount4 = service.convertCurrency("USD", "JPY", 400);
        System.out.println("amount1 :" + amount3); // cache NOT hit

        double amount5 = service.convertCurrency("GBP", "JPY", 500);
        System.out.println("amount1 :" + amount3); // cache NOT hit

        double amount6 = service.convertCurrency("SGD", "JPY", 600);
        System.out.println("amount1 :" + amount3); // cache NOT hit

        double amount7 = service.convertCurrency("USD", "JPY", 700);
        System.out.println("amount1 :" + amount3); // cache hit!

    }
}

class CurrencyConversionService {

    ConversionRateProvider provider;
    CacheManager cacheManager;

    public CurrencyConversionService(ConversionRateProvider provider, CacheManager cacheManager) {
        this.provider = provider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double currencyRate = cacheManager.get(currencyPair);
        if (currencyRate == null) {
            currencyRate = provider.getCurrencyRate(fromCurrency, toCurrency);
            cacheManager.put(currencyPair, currencyRate);
        }
        return amount * currencyRate;
    }
}

class ConversionRateProvider {

    public double getCurrencyRate(String fromCurrency, String toCurrency) {
        return 110.0;
    }
}

class CacheManager extends LinkedHashMap<String, Double> {

    int maxSize;

    public CacheManager(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Double> entry) {
        return size() > maxSize;
    }

    public Double get(String currencyPair) {
        if (!super.containsKey(currencyPair)) {
            System.out.println("Cache NOT hit!");
            return null;
        }
        System.out.println("Cache hit!");
        return super.get(currencyPair);

    }

    public void put(String currencyPair, double rate) {
        super.put(currencyPair, rate);
    }

}
