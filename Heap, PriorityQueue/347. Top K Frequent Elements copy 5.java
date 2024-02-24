class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        //[(1,3) (2,2) (3,1)]
        //この構造を維持したままで pqにいれるか
        // pqにはintだけをいれて、後ほど構築するか
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> map.get(n2) - map.get(n1));
        for(int key : map.keySet()){
            pq.add(key);
        }

        int limit = 0;
        int[] result = new int[k];
        while(limit< k){
            result[limit] = pq.poll();
            limit++;
        }
        return result;
    }
}

// speed : O(Nlog(k))
// space : O(N+k) map size N and pq size k 