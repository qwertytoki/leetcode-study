
class LRUCache {

    class ListNode {

        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, ListNode> dict;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        dict = new HashMap<>();
        this.capacity = capacity;
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

    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            remove(dict.get(key));
        }

        ListNode node = new ListNode(key, value);
        dict.put(key, node);
        add(node);
        if (dict.size() > capacity) {
            dict.remove(head.next.key);
            remove(head.next);
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(ListNode node) {
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prevEnd;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
