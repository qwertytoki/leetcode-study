class Solution {
    //dfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int r = 0; r< grid.length; r++){
            for(int c = 0; c< grid[0].length; c++){
                if(grid[r][c]=='1'){
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        int rEdge = grid.length;
        int cEdge = grid[0].length;
        if(r>=rEdge||c>=cEdge||r<0||c<0||grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}