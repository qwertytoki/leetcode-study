class Solution {
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(0, nums.length-2), robHelper(1,nums.length-1));
    }

    private int robHelper(int left, int right){
        int prevprev = 0;
        int prev = 0;
        for(int i = left; i<= right; i++){
            int num = nums[i];
            int current = Math.max(prev, prevprev + num);
            prevprev = prev;
            prev = current;
        }
        return prev;
    }
}