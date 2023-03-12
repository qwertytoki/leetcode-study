class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[100];
        Arrays.fill(memo,-1);
        return robFrom(0,nums);
    }

    private int robFrom(int i, int[] nums){
        if(i>= nums.length){
            return 0;
        }
        if(memo[i] > -1){
            return memo[i];
        }
        int ans = Math.max(robFrom(i+1, nums), robFrom(i+2, nums)+ nums[i]);
        memo[i]= ans;
        return ans;
    }
}