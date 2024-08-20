import java.util.HashMap;

class LRUCache<K, V> {
    private final int capacity;
    private final HashMap<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> cacheList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cacheList = new DoublyLinkedList<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null; // キャッシュにキーが存在しない場合
        }
        Node<K, V> node = map.get(key);
        cacheList.moveToFront(node); // 使用されたノードをリストの先頭に移動
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            cacheList.moveToFront(node); // 更新されたノードをリストの先頭に移動
        } else {
            if (map.size() == capacity) {
                Node<K, V> tail = cacheList.removeTail();
                map.remove(tail.key); // 最も古いノードをキャッシュとマップから削除
            }
            Node<K, V> newNode = new Node<>(key, value);
            cacheList.addToFront(newNode);
            map.put(key, newNode);
        }
    }

    // ノードクラス
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly Linked Listの実装
    private static class DoublyLinkedList<K, V> {
        private Node<K, V> head, tail;

        public DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public void addToFront(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToFront(Node<K, V> node) {
            remove(node);
            addToFront(node);
        }

        public Node<K, V> removeTail() {
            Node<K, V> node = tail.prev;
            remove(node);
            return node;
        }

        private void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache.get(1)); // "one" - キャッシュヒット
        cache.put(4, "four"); // キャッシュの容量を超えたため、"two"が削除される
        System.out.println(cache.get(2)); // null - "two"は削除されたためキャッシュミス
    }
}