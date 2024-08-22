class ListNode{
    ListNode prev;
    ListNode next;
    int key;
    int val;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> dict;
    ListNode tail;
    ListNode head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dict = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!dict.containsKey(key)){
            return -1;
        }
        ListNode node = dict.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(dict.containsKey(key)){
            remove(dict.get(key));
        }
        ListNode node = new ListNode(key, value);
        add(node);
        dict.put(key, node);
        if(dict.size()>capacity){
            ListNode deleteTarget = head.next;
            remove(deleteTarget);
            dict.remove(deleteTarget.key);
        }
    }


    private void add(ListNode node){
        ListNode preEnd = tail.prev;
        preEnd.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = preEnd;

    }

    private void remove(ListNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */