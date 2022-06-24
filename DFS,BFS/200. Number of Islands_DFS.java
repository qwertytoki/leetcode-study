class Solution {
    
    // 再帰的に島を塗りつぶしていく。
    // if the land is 1, numberOfLand+1, and turns it as 0.
    // also to seek adjacent land, call same method with changing their coordinate 1 by 1. 
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numberOfIslands = 0;
        
        for(int r=0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(grid[r][c] == '1'){
                    numberOfIslands++;
                    dfs(grid,r,c);
                }
            }
        }
        
        
        return numberOfIslands;
    }
    
    void dfs(char[][] grid,int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0 || c<0 || r>= nr|| c>= nc || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    
}
