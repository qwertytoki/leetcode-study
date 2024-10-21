class Solution {
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(0, nums.length-2), helper(1, nums.length-1));
    }


    private int helper(int start, int end){
        int prevprev = nums[start];
        int prev = Math.max(nums[start], nums[start+1]);
        for(int i =start+2; i<=end; i++){
            int current = Math.max(prev, prevprev+nums[i]);
            prevprev = prev;
            prev = current;
        }
        return prev;
    }
}