class Solution {
    
    int[][] grid;
    boolean [][] seen; //こうやれば値を変えずに判定ができるのか
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        
        int maxArea =0;
        for(int r = 0;r<grid.length;r++){
            for(int c = 0; c <grid[0].length; c++){
                //現在の島の面積を探すロジック
                int currArea = countArea(r,c);
                maxArea= currArea > maxArea ? currArea : maxArea;
            }
        }
        return maxArea;
    }
    
    private int countArea(int row, int col){
        if(row<0 || col<0 || row>= grid.length || col>= grid[0].length || seen[row][col] || grid[row][col] ==0){
            return 0;
        }
        seen[row][col] = true;
        
        return(1 + countArea(row-1,col)+ countArea(row+1,col)+ countArea(row,col-1)+ countArea(row,col+1));
        
    }
}