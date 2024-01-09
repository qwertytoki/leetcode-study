class Solution {
    boolean[][] passed;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        passed = new boolean[m][n];
        for(int row = 0; row < m;row++){
            for(int col = 0; col <n; col++){
                if(grid[row][col] == 1 && !passed[row][col]){
                    result = Math.max(result, areaHelper(grid, row,col));
                }
            }
        }
        return result;
    }
    private int areaHelper(int[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        if(row >= m || row < 0 || col>=n || col<0 || grid[row][col]==0 || passed[row][col] ){
            return 0;
        }
        passed[row][col] = true;
        return 1 + areaHelper(grid, row+1,col) + areaHelper(grid, row-1, col) + areaHelper(grid, row,col-1) + areaHelper(grid, row, col+1);
    }
}