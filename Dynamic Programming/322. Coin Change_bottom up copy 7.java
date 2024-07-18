class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);

        int max = amount +1000;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        for(int i =1; i<= amount; i++){
            for(int j =0; j< coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] >amount ? -1 : dp[amount];
    }
}