class ListNode {
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
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> dict;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dict = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1); 
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
        dict.put(key, node);
        add(node);
        
        if(dict.size() > capacity){
            ListNode delTarget = head.next;
            remove(delTarget);
            dict.remove(delTarget.key);
        }
    }

    private void add(ListNode node){
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prevEnd;
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */