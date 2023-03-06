class Solution {
    // bottom up advanced
    // これは見事すぎる。 space complexityをO(1)まで抑えた。
    public int numWays(int n, int k) {
        if(n==1) return k;
        int twoPostBack = k;
        int onePostBack = k*k;
        
        for(int i = 3; i<=n; i++){
            int curr = (k-1)*(onePostBack + twoPostBack);
            twoPostBack = onePostBack;
            onePostBack = curr;
        }
        return onePostBack;
    }
}