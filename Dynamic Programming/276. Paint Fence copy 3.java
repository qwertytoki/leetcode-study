class Solution {
    Map<Integer,Integer> memo;
    int k;
    public int numWays(int n, int k) {
        this.memo = new HashMap<>();
        this.k = k;
        return calcWithMemo(n);
    }

    private int calcWithMemo(int n){
        if(n ==1){
            return k;
        }
        if(n == 2){
            return k*k;
        }
        // n-1 and n is different color -> (k-1)* calcWays(n-1,k);
        // n-1 and n is same,but n-2 and n is different -> (k-1) * calcWays(n-2,k);
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        memo.put(n,(k-1) * calcWithMemo(n-1) + (k-1)* calcWithMemo(n-2));

        return memo.get(n);
    }
}