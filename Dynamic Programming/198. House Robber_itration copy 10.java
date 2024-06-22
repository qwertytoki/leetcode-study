class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int prevprev = nums[0];
        int prev = Math.max(nums[0], nums[1]);    

        for(int i =2; i<nums.length; i++){
            int current = Math.max(prev, prevprev+nums[i]);
            prevprev = prev;
            prev = current;
        }
        return prev;
    }

    
}