class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numWays(int n, int k) {
        return totalCounts(n,k);
    }

    private int totalCounts(int n, int k){
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        memo.put(n,(k-1) * (totalCounts(n-1, k) + totalCounts(n-2, k)));
        return memo.get(n);
    }
}