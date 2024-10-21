class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount +1;
        int[] dp = new int[amount + 1]; // dpにはi円をつくるためのコインの最小枚数が入る
        Arrays.fill(dp, max); // とりあえずありえない数字をいれる
        dp[0] = 0;  //0のときは必ず0枚
        for(int i = 1; i<= amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){ 
                    //難しくみえるが、dp[0]=0からの再帰を行ってる
                    //i - coins[j]=0になる= 自分自身のコインを足せば目的の数字になる
                    //したがって、dp[i] =1 となる→あとはそれの積み重ね
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
/**
例えば、coins = [1, 2, 5] と amount = 11 の場合、DPテーブル dp は以下のように更新されます：

	•	dp[1] = 1 (コイン 1 を1枚使用)
	•	dp[2] = 1 (コイン 2 を1枚使用)
	•	dp[3] = 2 (コイン 1 を1枚使用 コイン 2 を1枚使用)
	•	dp[4] = 2 (コイン 2 を2枚使用)
	•	dp[5] = 1 (コイン 5 を1枚使用)
	•	dp[6] = 2 (コイン 5 を1枚、コイン 1 を1枚使用)
	•	dp[7] = 2 (コイン 5 を1枚、コイン 2 を1枚使用)
	•	dp[8] = 3 (コイン 5 を1枚、コイン 2 を1枚、コイン 1 を1枚使用)
	•	dp[9] = 3 (コイン 5 を1枚、コイン 2 を2枚使用)
	•	dp[10] = 2 (コイン 5 を2枚使用)
	•	dp[11] = 3 (コイン 5 を2枚、コイン 1 を1枚使用)
 */
    }
}