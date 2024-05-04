class Solution {
    public int rob(int[] nums) {
        int arrLen = nums.length;
        int[] maxRob = new int[arrLen+1];
        maxRob[arrLen] = 0;
        maxRob[arrLen-1] = nums[arrLen-1];

        for(int i = arrLen-2; i>=0; i--){
            maxRob[i] = Math.max(maxRob[i+1], maxRob[i+2]+nums[i]);
        }

        return maxRob[0];
    }
}