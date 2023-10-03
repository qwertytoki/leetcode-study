class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int longest= 0;
        for(int i : dp){
            longest = Math.max(i, longest);
        }
        return longest;
        
        /**
        2 11 100 6 7 8 9 10 3 4 
        1  1   1 1 1 1 1  1 1 1
        ↓ 自分より左に自分より小さい数字があれば＋1する
        2 11 100 6 7 8 9 10 3 4 
        1  2   3 2 3 4 5  6 2 3   
        その中で一番大きい数字が答え
        longestは6
         */
        

    }
}