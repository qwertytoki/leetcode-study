
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

class Wise_LRUCache_10 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3); //maxSize is 3;
        System.out.println(cache.get("SGD_JPY")); // cache NOT hit
        cache.put("SGD_JPY", 110.0);
        System.out.println(cache.get("SGD_JPY")); // cache hit
        cache.put("USD_JPY", 140.0);
        cache.put("AUD_JPY", 120.0);
        cache.put("CND_JPY", 115.0);
        System.out.println(cache.get("SGD_JPY")); // cache NOT hit : maxSize is 3;
        System.out.println(cache.get("USD_JPY")); // cache hit
        cache.put("SGD_USD", 0.7);
        System.out.println(cache.get("USD_JPY")); // cache hit
        System.out.println(cache.get("AUD_JPY")); // cache NOT hit
    }
}

class LRUCache {

    private final int maxSize;
    private final Map<String, Double> dict = new ConcurrentHashMap<>();
    private final Deque<String> accessOrder = new ConcurrentLinkedDeque<>();

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public Double get(String key) {
        if (!dict.containsKey(key)) {
            System.out.println("Cache Not hit!");
            return null;
        }
        System.out.println("Cache hit!");
        accessOrder.remove(key);
        accessOrder.addLast(key);
        return dict.get(key);
    }

    public void put(String key, double value) {
        if (dict.containsKey(key)) {
            accessOrder.remove(key);
        } else if (dict.size() == maxSize) {
            String deleteTargetKey = accessOrder.pollFirst();
            dict.remove(deleteTargetKey);
        }
        accessOrder.add(key);
        dict.put(key, value);
    }

}
