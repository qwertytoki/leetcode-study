class Solution {
    // DFS
    private void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0||c<0||nr<=r||nc<=c || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int number = 0;
        for(int r = 0;r<nr;r++){
            for(int c = 0;c<nc;c++){
                if(grid[r][c]=='1'){
                    number++;
                    dfs(grid,r,c);
                }
            }
        }
        return number;
    }
}