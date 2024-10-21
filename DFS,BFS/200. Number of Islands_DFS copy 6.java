class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int count = 0;
        for(int row = 0; row<rowLen;row++){
            for(int col =0; col<colLen; col++){
                if(grid[row][col]=='1'){
                    count++;
                    dfs(row,col,rowLen,colLen, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int rowLen, int colLen, char[][] grid){
        if(row<0 || col<0|| row >= rowLen|| col >= colLen || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        dfs(row+1,col,rowLen,colLen,grid);
        dfs(row-1,col,rowLen,colLen,grid);
        dfs(row,col+1,rowLen,colLen,grid);
        dfs(row,col-1,rowLen,colLen,grid);
    }
}