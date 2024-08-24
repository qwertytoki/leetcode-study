import java.util.*;

interface ExchangeRateProvider {
    double getExchangeRate(String fromCurrency, String toCurrency) throw Exception;
}

class APIClientA impelements ExchangeRateProvider{
    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency)throws Exception{
        // for testing
        // throw new Exception("API Client A is down!");
        System.out.println("APIClientA dummy call. ");
        return 1.12;   
    }
}

class APIClientB implements ExchangeRateProvider{
    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency){
        //dummy call
        System.out.println("APIClientB dummy call. ");
        return 1.15;
    }
}

class FallbackExchangeRateProvider implements ExchangeRateProvider {
    private final List<ExchangeRateProvider> providers;
    
    public FallbackExchangeRateProvider(List<ExchangeRateProvider> providers){
        this.providers = providers;
    }

    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception{
        for(ExchangeRateProvider provider:providers){
            try{
                return provider.getExchangeRate(fromCurrency, toCurrency);
            } catch(Exception e){
                System.out.println("Failed to get rate from provider. trying next." + e.getMessage());
            }
        }
        throw new Exception("all providers failed to return the rate. Please check ASAP!");
    }
}

class CacheManager {
    private static class CacheEntry{
        double rate;
        long timestamp;

        CacheEtnry(double rate, long timestamp){
            this.rate = rate;
            this.timestamp = timestamp;
        }
    }
    private final Map<String, CacheEntry> cache = new HashMap<>();
    private final long cacheExpiryTimeMillis;

    public CacheManager(long cacheExpiryTimeMillis){
        this.cacheExpiryTimeMillis = cacheExpiryTimeMillis;
    }

    public Double getRateFromCache(String currencyPair) {
        CacheEntry entry = cache.get(currencyPair);
        if(entry != null && (System.currentTimeMillis() - entry.timestamp) < cacheExpiryTimeMillis){
            System.out.println("cache hit for "+currencyPair);
            return entry.rate;
        }
        System.out.println("cache does not hit for " + currencyPair);
        return null;
    }

    public void storeRateInCache(Stirng currencyPair, double rate){
        System.out.println("cache store for "+currencyPair);
        cache.put(currencyPair, new CacheEntry(rate, System.currentTimeMillis()));
    }
}

class CurrencyConverterService {
    private final ExchangeRateProvider;
    private final CacheManager;

    public CurrencyConverterService(ExchangeRateProvider provider, CacheManager cacheManager){
        this.ExchangeRateProvider = provider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency. double amount) throws Exception{
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.getRateFromCache(currencyPair);
        if(rate == null){
            rate = provider.getExchangeRate(fromCurrency, toCurrency);
            cacheManager.storeRateInCache(currencyPair, rate);
        }
        return amount * rate;
    }
}

//Main Class
public class CurrencyExchange{
    public static void main(String[] args){
        List<ExchangeRateProvider> providers = Arrays.asList(new APIClientA(), new APIClientB);
        ExchangeRateProvider rateProvider = new FallbackExchangeRateProvider(providers);
        CacheManager cacheManager = new CacheManager(60000);
        CurrencyConverterService converterService = new CurrencyConverterService(rateProvder, cacheManager);
        
        try{
            double convertAmount1 = convertService.convertCurrency("USD", "EUR", 100);
            System.out.println("Converted amount 1: " + convertedAmount1);

            //cache will hit
            double convertAmount2 = convertService.convertCurrency("USD", "EUR", 200);
            System.out.println("Converted amount 2: " + convertedAmount2);
            
            //cache will not hit
            double convertAmount3 = convertService.convertCurrency("USD"
            System.out.println("Converted amount 3: " + convertedAmount3);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

