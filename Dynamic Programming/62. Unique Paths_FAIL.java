class Solution {
    public int uniquePaths(int m, int n) {
        // it works but too slow
        if(m==1 || n==1) return 1;
        return uniquePaths(m-1,n)+ uniquePaths(m,n-1);
    }
}