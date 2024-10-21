class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int keyCount = 1;
        int currentSum = 0;
        map.put(currentSum, keyCount);
        for(int num : nums){
            currentSum += num;
            if(map.containsKey(currentSum-k)){
                count += map.get(currentSum-k);
            }
            map.put(currentSum, map.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
}