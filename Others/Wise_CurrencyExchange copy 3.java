
import java.util.*;

interface RateProvider {

    double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception;
}

class APIClientA implements RateProvider {

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        throw new Exception("dummy exception for fallback test!");
        // System.out.println("return APIClientA dummy rate");
        // return 110.0;
    }

}

class APIClientB implements RateProvider {

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {
        throw new Exception("dummy exception for fallback test!");
        // System.out.println("return APIClientB dummy rate");
        // return 115.0;
    }
}

class FallbackExchangeProvider implements RateProvider {

    private final List<RateProvider> providers;

    FallbackExchangeProvider(List<RateProvider> providers) {
        this.providers = providers;
    }

    @Override
    public double getCurrencyRate(String fromCurrency, String toCurrency) throws Exception {

        for (RateProvider provider : providers) {
            try {
                return provider.getCurrencyRate(fromCurrency, toCurrency);
            } catch (Exception e) {
                System.out.println("API failed, will try next provider");
            }
        }
        throw new Exception("all providers failed, please check ASAP!");
    }
}

class Main {

    public static void main(String[] args) {
        RateProvider rateProvider = new FallbackExchangeProvider(Arrays.asList(new APIClientA(), new APIClientB()));
        try {
            double rate = rateProvider.getCurrencyRate("SGD", "JPY");
            System.out.println("converted value is :" + rate * 1000);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
