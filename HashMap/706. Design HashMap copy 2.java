class ListNode {
    int key, value;
    ListNode next;
    public ListNode(int key, int value, ListNode next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class MyHashMap {
    static final int size = 19997;
    static final int multi = 12582917;
    ListNode[] data;
    public MyHashMap() {
         this.data = new ListNode[size];
    }
    private int hash(int key){
        return (int)((long)key*multi % size);
    }
    
    public void put(int key, int value) {
        remove(key);
        int hash = hash(key);
        ListNode node = new ListNode(key,value,data[hash]);
        data[hash] = node;
    }
    
    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        for(;node!= null;node = node.next){
            if(node.key == key)return node.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        if(node == null){
            return;
        }
        if(node.key == key){
            data[hash] = node.next;
        }
        for(;node.next != null;node = node.next){
            if(node.next.key == key){
                node.next = node.next.next;
                return;
            }
        }    
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */