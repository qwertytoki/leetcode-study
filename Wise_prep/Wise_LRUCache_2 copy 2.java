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

class LRUCache{
    ListNode tail;
    ListNode head;
    Map<Integer, ListNode> dict;
    int capacity;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.dict = new HashMap<>();
        this.tail = new ListNode(-1,-1);
        this.head = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!dict.containsKey(key)){
            return -1;
        }
        ListNode node = dict.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int val){
        if(dict.containsKey(key)){
            remove(dict.get(key));
        }
        ListNode node = new ListNode(key, val);
        dict.put(key, node);
        add(node);
        if(dict.size()>capacity){
            ListNode delCandidate = head.next;
            remove(delCandidate);
            dict.remove(delCandidate.key);
        }
    }

    private void add(ListNode node){
        ListNode prevEnd = tail.prev;
        node.next = tail;
        node.prev = prevEnd;
        tail.prev = node;
        prevEnd.next = node;
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }



}