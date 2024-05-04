class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[100];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }

        if(memo[i] >= 0){
            return memo[i];
        }
        memo[i] = Math.max(helper(nums, i+1), helper(nums, i+2)+nums[i]);
        return memo[i];

    }
}