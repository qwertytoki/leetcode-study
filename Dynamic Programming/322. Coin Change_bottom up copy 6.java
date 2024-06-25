class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+10000;
        int[] numbers = new int[amount+1];
        Arrays.fill(numbers, max);
        numbers[0] = 0;
        int sum = 0;

        for(int i = 1; i<= amount; i++){
            for(int j = 0; j< coins.length; j++){
                if(coins[j] <= i){
                    numbers[i] = Math.min(numbers[i], numbers[i - coins[j]]+1);
                }
            }
        }
        return numbers[amount] > amount ? -1 : numbers[amount];
    }
}