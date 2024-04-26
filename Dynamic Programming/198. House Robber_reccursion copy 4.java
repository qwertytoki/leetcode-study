class Solution {
    int[] memo;
    public int rob(int[] nums) {
        //1つ飛ばす場合と2つ飛ばす場合を考えないといけない
        //20 1 1 100 みたいなとき
        //自分と、自分+2をとるか
        //自分+1をとるか
        memo = new int[100];
        Arrays.fill(memo,-1);
        return helper(0, nums);
    }

    private int helper(int i, int[] nums){
        if(i>=nums.length){
            return 0;
        }
        if(memo[i]>-1){
            return memo[i];
        }
        //i+1を選んだ未来 iとi+2を選んだ未来(実際にはその先でまたi+2を選ぶ場合がある)
        memo[i] = Math.max(helper(i+1, nums), helper(i+2, nums) + nums[i]);
        return memo[i];
    }
}