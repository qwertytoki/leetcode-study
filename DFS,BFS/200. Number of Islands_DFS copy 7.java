class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int count = 0;
        for(int r =0; r<rowLen; r++){
            for(int c =0; c<colLen; c++){
                if(grid[r][c]=='1'){
                    count++;
                    helper(r,c,rowLen, colLen,grid);
                }
            }
        }
        return count;
    }

    private void helper(int r, int c, int rowLen, int colLen, char[][] grid){
        grid[r][c] = '0';
        if(r-1>=0 && grid[r-1][c] == '1'){
            helper(r-1,c,rowLen,colLen,grid);    
        }
        if(r+1<rowLen && grid[r+1][c] == '1'){
            helper(r+1, c, rowLen, colLen, grid);
        }
        if(c-1>=0 && grid[r][c-1]=='1'){
            helper(r,c-1, rowLen,colLen,grid);
        }
        if(c+1<colLen && grid[r][c+1] == '1'){
            helper(r,c+1, rowLen, colLen, grid);
        }
    }
}