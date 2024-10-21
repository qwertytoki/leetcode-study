class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[100];
        Arrays.fill(memo,-1);
        return helper(0,nums);
    }

    //nとn+2 を選ぶか, n+1を選ぶかを判断するロジックにする
    private int helper(int i, int[] nums){
        if(i>= nums.length){
            return 0;
        }
        if(memo[i]>-1){
            return memo[i];
        }

        memo[i] = Math.max(helper(i+1, nums), helper(i+2, nums) + nums[i]);
        return memo[i];
    }
}