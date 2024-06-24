class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount +1000;
        // memo は[amount]の金額を満たすための最小値が入るメモ
        int[] memo = new int[amount+1];
        Arrays.fill(memo, max);
        memo[0] = 0;
        for(int i = 1; i<= amount; i++){
            for(int j =0; j< coins.length; j++){
                if(coins[j]<= i){
                    memo[i] = Math.min(memo[i], memo[i - coins[j]]+1);
                }
            }
        }
        return memo[amount] > amount ? -1 : memo[amount]; 
    }
}