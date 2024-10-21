class Solution {
    Map<Integer,Integer> memo = new HashMap<>();
    public int numWays(int n, int k) {
        return totalWays(n,k);
    }

    private int totalWays(int number, int color){
        if(number==1)return color;
        if(number==2)return color*color;
        if(memo.containsKey(number)){
            return memo.get(number);
        }
        memo.put(number, (color-1)*(totalWays(number-1, color)+totalWays(number-2, color)));

        return memo.get(number);
    }
}