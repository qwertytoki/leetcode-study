class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        return robFrom(0,nums);
    }

    private int robFrom(int i, int[] nums){
        if(i >= nums.length){
            return 0;
        }
        if(memo[i] > -1){
            return memo[i];
        }
        int answer = Math.max(robFrom(i+1, nums), robFrom(i+2, nums) + nums[i]);
        memo[i] = answer;
        return answer;
    }
}