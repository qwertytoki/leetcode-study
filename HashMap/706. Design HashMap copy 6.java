
class ListNode {

    int key;
    int val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

class MyHashMap {

    static final int size = 19997; // 適当な大きい数字、素数だといいとかだった気がする
    static final int multi = 12582917; // 適当な大きい数字、素数だといいとかだった気がする
    ListNode[] data;

    public MyHashMap() {
        this.data = new ListNode[size];
    }

    public void put(int key, int value) {
        remove(key);
        int hash = hash(key);
        ListNode node = new ListNode(key, value, data[hash]);
        data[hash] = node;
    }

    private int hash(int key) {
        return (int) ((long) key * multi % size);
    }

    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        if (node == null) {
            return;
        }
        if (node.key == key) {
            data[hash] = node.next;
        }
        while (node.next != null) {
            if (node.next.key == key) {
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
