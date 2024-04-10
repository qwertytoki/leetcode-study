class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int count = 0;
        for(int r = 0;r<rowLen;r++){
            for(int c = 0; c<colLen;c++){
                if(grid[r][c]=='1'){
                    count++;
                    dfs(r,c,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid){
        int rowLen = grid.length;
        int colLen = grid[0].length;
        grid[r][c] = '0';
        if(r-1>=0&& grid[r-1][c]=='1'){
            dfs(r-1,c,grid);    
        }
        if(r+1<rowLen&& grid[r+1][c]=='1'){
            dfs(r+1,c,grid);
        }
        if(c-1>=0&& grid[r][c-1]=='1'){
            dfs(r,c-1,grid);
        }
        if(c+1<colLen&& grid[r][c+1]=='1'){
            dfs(r,c+1,grid);
        }
    }
}