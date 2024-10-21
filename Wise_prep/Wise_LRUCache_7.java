
import java.util.*;

public class Wise_LRUCache_7 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        System.out.println(cache.get(1)); // cache not hit
        cache.put(1, 100);
        System.out.println(cache.get(1)); // cache hit
        cache.put(2, 200);
        cache.put(3, 300);
        cache.put(4, 400);
        System.out.println(cache.get(1)); // cache not hit
        System.out.println(cache.get(2)); // cache hit
        cache.put(5, 500);
        System.out.println(cache.get(2)); // cache hit
        System.out.println(cache.get(3)); // cache not hit
    }
}

class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int maxSize;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> map) {
        return size() > maxSize;
    }

    public int get(int key) {
        if (!super.containsKey(key)) {
            System.out.println("cache not hit!");
            return -1;
        }
        System.out.println("cache hit!");
        return super.get(key);
    }

    public void put(int key, int val) {
        super.put(key, val);
    }
}
