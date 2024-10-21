class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int maxArea = 0;

        for(int r =0;r<rowLen;r++){
            for(int c=0; c<colLen; c++){
                if(grid[r][c]==1){
                    maxArea = Math.max(maxArea, helper(r,c,grid));
                }
            }
        }
        return maxArea;
    }

    private int helper(int row, int col, int[][] grid){
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if(row<0||row>=rowLen||col<0||col>=colLen||grid[row][col]==0){
            return 0;
        }
        grid[row][col] = 0;
        return helper(row-1,col,grid) +helper(row+1,col,grid) +helper(row,col-1,grid) +helper(row,col+1,grid)+1;
        
    }
}