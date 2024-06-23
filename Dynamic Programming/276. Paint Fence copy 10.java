class Solution {
    public int numWays(int n, int k) {
        int[] memo = new int[n+1];
        return totalWays(n,k, memo);
    }

    private int totalWays(int number, int color, int[] memo){
        if(number == 1){
            return color;
        }
        if(number == 2){
            return color*color;
        }
        if(memo[number] != 0){
            return memo[number];
        }
        int ways = (color -1) * (totalWays(number-1, color, memo) + totalWays(number-2, color, memo));
        memo[number] = ways;
        return memo[number];
    }
}