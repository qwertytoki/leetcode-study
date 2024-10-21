class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int tribonacci(int n) {
        map.put(0,0);
        map.put(1,1);
        map.put(2,1);
        if(map.containsKey(n))return map.get(n);
        map.put(n,tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1));
        return map.get(n);
    }
}