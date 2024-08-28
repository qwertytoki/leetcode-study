
import java.util.*;

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

    Map<Integer, ListNode> dict;
    ListNode head;
    ListNode tail;
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
            return -1;
        }
        ListNode node = dict.get(key);
        remove(node);
        add(node);
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
            ListNode delCandidate = head.next;
            dict.remove(delCandidate.key);
            remove(delCandidate);
        }
    }

    private void add(ListNode node) {
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prevEnd;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
