class Solution {

    int[] memo;
    public int rob(int[] nums) {
        this.memo = new int[101];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }
        if(memo[index]>-1){
            return memo[index];
        }
        memo[index] = Math.max(helper(nums, index+1), helper(nums, index+2) + nums[index]);
        return memo[index];
    }

    
}