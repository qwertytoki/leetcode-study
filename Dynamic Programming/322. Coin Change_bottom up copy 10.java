class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] coinCount = new int[amount+1];
        Arrays.fill(coinCount, max);
        coinCount[0] = 0;
        
        for(int i = 1; i<=amount; i++){
            for(int j = 0; j< coins.length; j++){
                if(coins[j]<=i){
                    coinCount[i] = Math.min(coinCount[i-coins[j]]+1, coinCount[i]);
                }
            }
        }
        return coinCount[amount]>amount ? -1: coinCount[amount];
    }
}