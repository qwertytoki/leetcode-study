class Solution {
    Map<Integer, Integer> memoMap = new HashMap<>();
    public int numWays(int n, int k) {
        if(n == 1){
            return k;
        }
        if(n == 2){
            return k*k;
        }

        if(memoMap.containsKey(n)){
            return memoMap.get(n); 
        }
        memoMap.put(n, (k-1)*(numWays(n-1,k) + numWays(n-2,k)));
        return memoMap.get(n);
    }
}