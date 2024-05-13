class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currentTotal = 0;
        int keyCount =1;
        map.put(currentTotal, keyCount);
        for(int num:nums){
            currentTotal+= num;
            if(map.containsKey(currentTotal - k)){
                count += map.get(currentTotal -k);
            }
            map.put(currentTotal, map.getOrDefault(currentTotal,0)+1);
        }
        return count;
        
    }
}