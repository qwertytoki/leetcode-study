
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;



class Wise_LRUCache_11{
    public static void main(String[] args){

    }
}

class LRUCache{
    int maxSize;
    Map<String, Double> rateMap = new ConcurrentHashMap<>();
    Deque<String> accessOrder = new ConcurrentLinkedDeque<>();

}