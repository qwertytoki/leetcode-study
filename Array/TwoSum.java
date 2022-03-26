class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> requiredNumberMap = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            if(requiredNumberMap.get(nums[i]) != null){
                //we have a match!
                int[] resultNums = new int[2];
                resultNums[0] = requiredNumberMap.get(nums[i]);
                resultNums[1] = i;
                return resultNums;
            }
            requiredNumberMap.put(target-nums[i], i);
        }
        return null;
    }
}