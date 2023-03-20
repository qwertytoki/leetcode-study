class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(0,coins, amount);
    }
    private int coinChange(int index, int[]coins, int amount){
        if(amount == 0){
            return 0;
        }

        if(index < coins.length && amount >0){
            int maxVal = amount/coins[index];
            int minCount = Integer.MAX_VALUE;
            for(int i =0; i<= maxVal; i++){
                if(amount >= i * coins[index]){
                    int res = coinChange(index+1,coins, amount - i * coins[index]);
                    if(res != -1){
                        minCount = Math.min(res + i, minCount);
                    }
                }
            }
            return minCount == Integer.MAX_VALUE ? -1 : minCount;
        }
        return -1;
    }
}