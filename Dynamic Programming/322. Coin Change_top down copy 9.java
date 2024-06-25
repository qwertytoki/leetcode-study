class Solution {
    public int coinChange(int[] coins, int amount) {
        return ccHelper(coins, amount, new int[amount+1]);
    }

    private int ccHelper(int[] coins, int amount, int[] memo){
        if(amount == 0){
            return 0;
        }
        if(amount <0){
            return -1;
        }
        if(memo[amount-1]!=0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            int result = ccHelper(coins, amount - coin, memo);
            if(result >=0 && result < min){
                min = result +1;
            }
        }
        memo[amount-1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount-1];
    }
}