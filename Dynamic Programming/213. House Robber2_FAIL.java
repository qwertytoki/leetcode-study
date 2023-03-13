class Solution {
    public int rob(int[] nums) {
        // 最初の値を終端に足して、return直前に終端の値をマイナスする

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] numsPlusOne = new int[nums.length+1];
        for(int i=0;i<nums.length; i++){
            numsPlusOne[i] = nums[i];
        }
        numsPlusOne[nums.length] = nums[0];

        int len = numsPlusOne.length;
        int robNext = numsPlusOne[len-1];
        int robNextPlusOne = 0;
        for(int i = len-2; i>=0;i--){
            int current = Math.max(robNext, robNextPlusOne + numsPlusOne[i]);
            robNextPlusOne = robNext;
            robNext = current;
            
        }
        return robNext - nums[0];

    }
}