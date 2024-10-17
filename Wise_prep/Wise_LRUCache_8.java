
import java.util.Map;
import java.util.LinkedHashMap;

class Wise_LRUCache_8 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        System.out.println(cache.get("SGD_JPY")); //cache not hit
        cache.put("SGD_JPY", 110.0);
        System.out.println(cache.get("SGD_JPY")); //cache hit
        cache.put("SGD_USD", 0.7);
        cache.put("SGD_AUD", 1.0);
        cache.put("SGD_EUR", 0.5);
        System.out.println(cache.get("SGD_JPY")); //cache not hit
        System.out.println(cache.get("SGD_USD")); //cache hit
        cache.put("AUD_JPY", 110.0);
        System.out.println(cache.get("SGD_USD")); //cache hit
    }

}

class LRUCache extends LinkedHashMap<String, Double> {

    private final int maxSize;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Double> map) {
        return size() > maxSize;
    }

    public Double get(String key) {
        Double value = super.get(key);
        if (value == null) {
            System.out.println("Cache not hit! Key : " + key);
            return -1.0;
        }
        System.out.println("Cache Hit! Key : " + key);
        return value;
    }

    public void put(String key, double value) {
        super.put(key, value);
    }

}
