class Solution {
    int nr, nc;
    public int numIslands(char[][] grid) {
        //DFS
        int number = 0;
        if(grid == null || grid.length == 0){
            return number;
        }
        nr = grid.length;
        nc = grid[0].length;
        for(int row = 0;row<nr; row++){
            for(int col = 0;col<nc;col++){
                if(grid[row][col]== '1'){
                    number++;
                    dfs(grid,row,col);
                }
            }
        }
        return number;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row<0 || row>=nr||col<0||col>=nc||grid[row][col]=='0'){
            return;
        }
        grid[row][col] = '0';
        
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
    
}