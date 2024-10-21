
import java.util.Map;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

class Wise_LRUCache_9 {

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

class LRUCache {

    private final int maxSize;
    private final Map<String, Double> cache = new ConcurrentHashMap<>();
    private final Deque<String> accessOrder = new ConcurrentLinkedDeque<>();

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public double get(String key) {
        if (!cache.containsKey(key)) {
            System.out.println("Cache not hit! key :" + key);
            return -1.0;
        }
        System.out.println("Cache hit! key :" + key);
        accessOrder.remove(key);
        accessOrder.addLast(key);
        return cache.get(key);
    }

    public void put(String key, double value) {
        if (cache.containsKey(key)) {
            accessOrder.remove(key);
        } else if (cache.size() >= maxSize) {
            String deleteTarget = accessOrder.pollFirst();
            cache.remove(deleteTarget);
        }
        accessOrder.addLast(key);
        cache.put(key, value);
    }

}
