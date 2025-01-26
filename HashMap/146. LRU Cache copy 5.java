
class LRUCache {

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

    Map<Integer, ListNode> dict;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
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

    public void put(int key, int value) {

        if (dict.containsKey(key)) {
            remove(dict.get(key));
        }
        ListNode node = new ListNode(key, value);
        add(node);
        dict.put(key, node);

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
        ListNode lastTail = tail.prev;
        lastTail.next = node;
        node.prev = lastTail;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
