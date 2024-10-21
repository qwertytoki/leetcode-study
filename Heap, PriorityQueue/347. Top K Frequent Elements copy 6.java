class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)-> map.get(n2)-map.get(n1));
        for(int key: map.keySet()){
            pq.add(key);
        }
        int[] result = new int[k];
        int index= 0;
        while(!pq.isEmpty() && index <k){
            result[index] = pq.poll();
            index++;
        }
        return result;
    }
}