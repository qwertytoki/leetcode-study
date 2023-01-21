//計算量はヒープソートなので O(Nlog k) < O(Nlog N) となる。

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i:nums){
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (q1,q2) -> countMap.get(q1) - countMap.get(q2));
        
        for(int i : countMap.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] resultArray = new int[k];
        for(int i=0;i<k;i++){
            resultArray[i] = pq.poll();
        }
        return resultArray;
    }
}
