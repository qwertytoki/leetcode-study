
class MyHashMap {

    Integer[] array;

    public MyHashMap() {
        array = new Integer[1000001];
    }

    public void put(int key, int value) {
        array[key] = value;
    }

    public int get(int key) {
        if (array[key] == null) {
            return -1;
        }
        return array[key];
    }

    public void remove(int key) {
        array[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
