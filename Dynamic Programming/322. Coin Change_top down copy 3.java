class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        this.memo = new int[amount+1];
        
        return changeHelper(coins, amount);
    }

    private int changeHelper(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(memo[amount]!=0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int result = changeHelper(coins, amount-coin);
            if(result >= 0 && result <min){
                min = result +1;
            }
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];

    }
    
}