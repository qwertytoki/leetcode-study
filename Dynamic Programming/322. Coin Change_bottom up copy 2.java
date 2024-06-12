class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[amount+1];
        int max = amount +10000;
        Arrays.fill(counts, max);
        counts[0] = 0;
        for(int i = 1; i<=amount; i++){
            for(int j = 0; j<coins.length; j++){
                if(coins[j]<=i){
                    counts[i] = Math.min(counts[i], counts[i-coins[j]]+1);
                }
            }
        }
        return counts[amount] >amount ? -1 : counts[amount]; 
    }
}