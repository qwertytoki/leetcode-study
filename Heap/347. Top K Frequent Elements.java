class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create hashmap to record how many count for each value
        // use PriorityQueue and sort by frequency.
        Map<Integer, Integer> map= new HashMap<>();
        for(int n :nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = 
            new PriorityQueue<>((a,b)-> (b.getValue()-a.getValue()));
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        int[] res = new int[k];
        for(int i = 0; i< k; i++){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res[i] = entry.getKey();
        }
        return res;
    }
}