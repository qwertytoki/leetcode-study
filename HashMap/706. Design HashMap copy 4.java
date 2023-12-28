class ListNode{
    int key, value;
    ListNode next;
    public ListNode(int key, int value, ListNode next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class MyHashMap {
    static final int size = 19997;  //大きな素数がいい
    static final int multi = 12582917; // 非常に大きな乱数がいい
    ListNode[] data;
    public MyHashMap() {
        this.data = new ListNode[size];
    }
    
    public void put(int key, int value) {
        remove(key);
        int hash = hash(key);
        ListNode node = new ListNode(key, value, data[hash]); //いままでのnodeをnode.nextにしてる。
        //hashが競合しても、今までの値はnode.nextに入ってるので探すことができる 
        data[hash] = node;   
    }

    private int hash(int key){
        return (int)((long)key * multi % size); //本来のMapのKeyの作成方法
    }
    
    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        while(node!= null){
            //ここでHashの競合が起きてるかどうかを探す
            if(node.key == key){
                return node.value;
            }
            node = node.next;
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
        while(node.next != null){
            if(node.next.key == key){
                node.next = node.next.next;
                return;
            }
            node = node.next;
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