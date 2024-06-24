class Solution {
    public int coinChange(int[] coins, int amount) {
        int max =  amount +10000;
        int[] coinNumbers = new int[amount+1];
        Arrays.fill(coinNumbers, max);
        coinNumbers[0] = 0;
        for(int i = 1; i<= amount ; i++){
            for(int j =0; j<coins.length; j++){
                if(coins[j] <= i){
                    coinNumbers[i] = Math.min(coinNumbers[i], coinNumbers[i-coins[j]]+1);
                }
            }
        }
        return coinNumbers[amount] > amount ? -1 : coinNumbers[amount];
    }
}