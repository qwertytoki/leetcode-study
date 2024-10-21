class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int current =0;
        for(int i =0;i<nums.length;i++){
            current += nums[i];
            if(map.containsKey(current-k)){
                count += map.get(current-k);
            }
            map.put(current, map.getOrDefault(current, 0)+1);
        }
        return count;
    }
}

// speed : O(N)
// space : O(N)
