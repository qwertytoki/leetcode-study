class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int[] a:grid){
            Arrays.fill(a,1);
        }
        for(int col=1;col<m;col++){
            for(int row=1;row<n;row++){
                grid[col][row] = grid[col-1][row] + grid[col][row-1];
            }
        }
        return grid[m-1][n-1];
    }
}