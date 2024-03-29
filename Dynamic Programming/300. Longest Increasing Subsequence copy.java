class Solution {
    // 言われてみればわかる、程度
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        for(int i=1; i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] >nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);  // ここがメイン。 わからん。
                }
            }
        }
        int longest = 0;
        for(int i: dp){
            longest = Math.max(longest,i);
        }
        return longest;
    }
}