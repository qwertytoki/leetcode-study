class Solution {
    int[] nums;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        this.nums = nums;
        return Math.max(robHelper(0, nums.length-2), robHelper(1, nums.length-1));
    }
    private int robHelper(int start, int end){
        int prevprev = 0;
        int prev = 0;
        for(int i =start; i<=end; i++){
            int current = Math.max(prev, prevprev+nums[i]);
            prevprev = prev;
            prev = current;
        }
        return prev;
    }
}