class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        return ccHelper(coins, amount, memo);
    }

    private int ccHelper(int[] coins, int remain, int[] memo){
        if(remain == 0){
            return 0;
        }
        if(remain < 0){
            return -1;
        }
        if(memo[remain]!= 0){
            return memo[remain];
        }
        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            int result = ccHelper(coins, remain-coin, memo);
            if(result>=0 && result <min ){
                min = result+1;
            }
        }
        memo[remain] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[remain];
        
    }
}