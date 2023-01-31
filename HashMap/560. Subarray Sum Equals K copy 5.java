class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap solution
        //1 create hashmap<Integer,Integer>
        //2 put the initial value to map
        //3 for loop by nums
        //4 if map containsKey of "sum - k" -> count += map.get()
        //5 put (sum, count of this key)

        //1 
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        //2
        map.put(0,1);
        //3
        for(int num:nums){
            //4 
            sum = sum + num;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            //5
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count; 
    }
}