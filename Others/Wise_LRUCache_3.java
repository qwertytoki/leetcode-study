
import java.util.*;

class Wise_LRUCache_3 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 100);
        System.out.println(cache.get(1)); //cache hit
        cache.put(2, 200);
        cache.put(3, 3000);
        cache.put(4, 400);
        cache.put(5, 500);
        System.out.println(cache.get(1)); // cache NOT hit
        System.out.println(cache.get(3)); //cache hit
    }
}

class ListNode {

    ListNode prev;
    ListNode next;
    int key;
    int val;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> dict;
    int maxSize;

    LRUCache(int maxSize) {
        this.maxSize = maxSize;
        dict = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!dict.containsKey(key)) {
            System.out.println("cache NOT hit!");
            return -1;
        }
        ListNode node = dict.get(key);
        remove(node);
        add(node);
        System.out.println("cache hit!");
        return node.val;
    }

    public void put(int key, int val) {
        if (dict.containsKey(key)) {
            remove(dict.get(key));
        }
        ListNode node = new ListNode(key, val);
        add(node);
        dict.put(key, node);
        if (dict.size() > maxSize) {
            ListNode deleteTarget = head.next;
            System.out.println("cache has more thax maxSize. key removed :" + deleteTarget.key);
            remove(deleteTarget);
            dict.remove(deleteTarget.key);
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(ListNode node) {
        ListNode prevLastVal = tail.prev;
        prevLastVal.next = node;
        tail.prev = node;
        node.prev = prevLastVal;
        node.next = tail;
    }

}
