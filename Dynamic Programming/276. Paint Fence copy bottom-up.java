class Solution {
    public int numWays(int n, int k) {
        if(n==1)return k;
        if(n==2)return k*k;
        int prevprev = k;
        int prev = k*k;
        for(int i = 3; i<=n; i++){
            int current = (k-1)*(prev+prevprev);
            prevprev = prev;
            prev = current; 
        }
        return prev;
    }
}