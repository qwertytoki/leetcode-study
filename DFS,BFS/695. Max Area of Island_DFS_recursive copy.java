class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //DFS
        //同様に1の島を0にしていく 
        //途中でカウントを挟む

        if(grid == null || grid.length == 0){
            return 0;
        }
        int rEdge = grid.length;
        int cEdge = grid[0].length;
        int max =0;
        for(int r=0;r<rEdge;r++){
            for(int c=0;c<cEdge;c++){
                if(grid[r][c]==1){
                    max = Math.max(dfs(grid,r,c),max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c){
        int rEdge = grid.length;
        int cEdge = grid[0].length;
        if(r<0 || c<0 ||r>= rEdge|| c>= cEdge || grid[r][c]==0){
            return 0;
        }
        
        grid[r][c] = 0;
        int area = 1 + dfs(grid,r-1,c) + dfs(grid,r+1,c)+ dfs(grid,r,c-1) + dfs(grid,r,c+1);
        return area;
    }
}