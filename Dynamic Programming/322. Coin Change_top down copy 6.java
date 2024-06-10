class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        
        if(amount==0)return 0;
        memo = new int[amount+1];
        return ccHelper(coins, amount);
    }

    private int ccHelper(int[] coins, int amount){
        if(amount==0)return 0;
        if(amount<0)return -1;
        if(memo[amount]!=0) return memo[amount];
        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            int result = ccHelper(coins, amount-coin);
            if(result>=0 && min>result){
                min = result+1;
            }
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }
}