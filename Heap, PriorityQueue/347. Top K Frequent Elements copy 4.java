class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num:nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> countMap.get(n2) - countMap.get(n1));
        for(int key : countMap.keySet()){
            pq.add(key);
        }

        int limit = 0;
        int[] result = new int[k];
        while(limit < k){
            result[limit] = pq.poll();
            limit++;
        }
        return result;
    }
}
 
// time: n(logn).   追加時にkを超えないように管理するとnlogkになる
// space: O(N+k).  mapがN、heapかk 

