class Solution {
    public int coinChange(int[] coins, int amount) {
        return ccHelper(coins, amount, new int[amount]);
    }

    private int ccHelper(int[] coins, int remain, int[] memo){
        if(remain == 0){
            return 0;
        }
        if(remain < 0){
            return -1;
        }
        if(memo[remain-1]!= 0){
            return memo[remain-1];
        }
        
        int min = Integer.MAX_VALUE;
        for(int coin :coins){
            int result = ccHelper(coins, remain - coin, memo);
            if(result >=0 && result <min){
                min = result +1;
            }
        }
        memo[remain -1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[remain-1];   
    }
}
