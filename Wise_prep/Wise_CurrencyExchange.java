import java.util.*;

interface ExchangeRateProvider {
    double getExchangeRate(String fromCurrency, String toCurrency) throws Exception;
}

class APIClientA implements ExchangeRateProvider {
    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        // ダミーのURLを使ってHTTPリクエストを送信する代わりに、例外をスロー
        // throw new Exception("API Client A is down!");
        System.out.println("Fetching rate from APIClientA...");
        return 1.12;  // ダミーのレート
    }
}

class APIClientB implements ExchangeRateProvider {
    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        // ダミーのURLを使ってHTTPリクエストを送信する代わりに、例外をスロー
        System.out.println("Fetching rate from APIClientB...");
        return 1.15;  // ダミーのレート
    }
}

class FallbackExchangeRateProvider implements ExchangeRateProvider {
    private final List<ExchangeRateProvider> providers;

    public FallbackExchangeRateProvider(List<ExchangeRateProvider> providers) {
        this.providers = providers;
    }

    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        for (ExchangeRateProvider provider : providers) {
            try {
                return provider.getExchangeRate(fromCurrency, toCurrency);
            } catch (Exception e) {
                System.out.println("Failed to get rate from provider, trying next: " + e.getMessage());
            }
        }
        throw new RuntimeException("All providers failed to get exchange rate");
    }
}

class CacheManager {
    private final Map<String, CacheEntry> cache = new HashMap<>();
    private final long cacheExpiryTimeMillis;

    public CacheManager(long cacheExpiryTimeMillis) {
        this.cacheExpiryTimeMillis = cacheExpiryTimeMillis;
    }

    public Double getRateFromCache(String currencyPair) {
        CacheEntry entry = cache.get(currencyPair);
        if (entry != null && (System.currentTimeMillis() - entry.timestamp) < cacheExpiryTimeMillis) {
            System.out.println("Cache hit for: " + currencyPair);
            return entry.rate;
        }
        System.out.println("Cache miss for: " + currencyPair);
        return null;
    }

    public void storeRateInCache(String currencyPair, double rate) {
        System.out.println("Storing rate in cache: " + currencyPair);
        cache.put(currencyPair, new CacheEntry(rate, System.currentTimeMillis()));
    }

    private static class CacheEntry {
        double rate;
        long timestamp;

        CacheEntry(double rate, long timestamp) {
            this.rate = rate;
            this.timestamp = timestamp;
        }
    }
}

class CurrencyConverterService {
    private final ExchangeRateProvider exchangeRateProvider;
    private final CacheManager cacheManager;

    public CurrencyConverterService(ExchangeRateProvider exchangeRateProvider, CacheManager cacheManager) {
        this.exchangeRateProvider = exchangeRateProvider;
        this.cacheManager = cacheManager;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String currencyPair = fromCurrency + "_" + toCurrency;
        Double rate = cacheManager.getRateFromCache(currencyPair);
        if (rate == null) {
            rate = exchangeRateProvider.getExchangeRate(fromCurrency, toCurrency);
            cacheManager.storeRateInCache(currencyPair, rate);
        }
        return amount * rate;
    }
}

public class CurrencyExchange {
    public static void main(String[] args) {
        List<ExchangeRateProvider> providers = Arrays.asList(new APIClientA(), new APIClientB());
        ExchangeRateProvider rateProvider = new FallbackExchangeRateProvider(providers);
        CacheManager cacheManager = new CacheManager(60000);  // キャッシュ有効期限を1分に設定
        CurrencyConverterService converterService = new CurrencyConverterService(rateProvider, cacheManager);

        try {
            // 最初の変換 - キャッシュミスが発生し、APIクライアントAを試す
            double convertedAmount1 = converterService.convertCurrency("USD", "EUR", 100);
            System.out.println("Converted amount 1: " + convertedAmount1);

            // 同じ通貨ペアで再度変換 - キャッシュヒットが発生
            double convertedAmount2 = converterService.convertCurrency("USD", "EUR", 200);
            System.out.println("Converted amount 2: " + convertedAmount2);

            // 新しい通貨ペアで変換 - キャッシュミスが発生し、APIクライアントAを試す
            double convertedAmount3 = converterService.convertCurrency("USD", "GBP", 150);
            System.out.println("Converted amount 3: " + convertedAmount3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}