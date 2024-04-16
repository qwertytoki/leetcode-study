class Solution {
    Map<Integer, Integer> map= new HashMap<>();
    public int numWays(int n, int k) {
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        map.put(n, (k-1)*(numWays(n-1,k) + numWays(n-2, k)));
        return map.get(n);
    }
}