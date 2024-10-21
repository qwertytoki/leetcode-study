class Solution {
    int[] nums;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        this.nums = nums;
        return Math.max(robHelper(1, nums.length-1), robHelper(0, nums.length-2));
    }

    private int robHelper(int left, int right){
        int prevprev = nums[left];
        int prev = Math.max(nums[left], nums[left+1]);
        for(int i = left+2; i<=right;i++){
            int current = Math.max(prevprev+nums[i], prev);
            prevprev = prev;
            prev = current;
        }
        return prev;
        
    }
}