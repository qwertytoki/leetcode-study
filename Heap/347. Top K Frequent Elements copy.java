class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //0 edge case
        //1 create Map<value, count of the value>
        //2 put it in the PriorityQueue and poll by size k
        //3 put all to array and return

        //0 
        if(nums.length == k){
            return nums;
        }
        //1 
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i : nums){
            if(countMap.containsKey(i)){
                int value = countMap.get(i);
                countMap.put(i,value+1);
            }else{
                countMap.put(i,1);
            }
        }
        //2 
        //うーむこんな事ができるのか。。
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1,n2)->countMap.get(n1)-countMap.get(n2)
        );
        for(int i : countMap.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        //3
        int[] result = new int[k];
        for(int i = 0; i<k;i++){
            result[i] = pq.poll();
        }
        return result;

    }
}