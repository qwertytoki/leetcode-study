
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    private Map<String, CacheValue> cache;
    private final long windowTimeMillis;

    CacheManager(long windowTimeMillis) {
        this.windowTimeMillis = windowTimeMillis;
        cache = new ConcurrentHashMap<>();
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
        cache.put(currencyPair, new CacheValue(rate, System.currentTimeMillis()));
    }

}
