class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinCount = new int[amount+1];
        int max = amount +100;
        Arrays.fill(coinCount, max);
        coinCount[0] = 0;
        for(int i =1; i<= amount; i++){
            for(int j = 0; j< coins.length; j++){
                if(coins[j]<= i){
                    coinCount[i] = Math.min(coinCount[i], coinCount[i - coins[j]]+1);
                }
            }
        }
        return coinCount[amount] > amount ? -1 : coinCount[amount];
    }
}