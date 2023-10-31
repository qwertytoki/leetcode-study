class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);

    }
    private int coinChange(int index, int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(index < coins.length && amount >0){
            int maxVal = amount/ coins[index];
            int minCost = Integer.MAX_VALUE;
            for(int x = 0; x <= maxVal; x++){
                int result = coinChange(index+1, coins, amount - coins[index]*x);
                if(result != -1){
                    minCost = Math.min(minCost, result + x);
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }
}