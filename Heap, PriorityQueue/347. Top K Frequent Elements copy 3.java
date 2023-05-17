class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i:nums){
            countMap.put(i,countMap.getOrDefault(i,0) +1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((u1,u2)->countMap.get(u1) - countMap.get(u2));
        for(int key: countMap.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = pq.poll();
        }
        return result;
    }
}

//time: O(nlogk)
//space: O(n+k)