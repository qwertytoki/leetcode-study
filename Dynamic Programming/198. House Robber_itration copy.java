class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int robNext = nums[len-1];
        int robNextPlusOne = 0;

        for(int i = len-2; i>=0; i--){
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            robNextPlusOne = robNext;
            robNext = current;
        } 
        return robNext;
    }
}