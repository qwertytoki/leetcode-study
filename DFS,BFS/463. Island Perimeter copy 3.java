class Solution {
    public int islandPerimeter(int[][] grid) {
        // if having neighbor in left and top, then -2 each. 
        // +4 if grid is 1
        int rowEnd = grid.length;
        int colEnd = grid[0].length;
        int result = 0;
        for(int row = 0; row< rowEnd; row++){
            for(int col = 0; col <colEnd; col++){
                if(grid[row][col] == 1){
                    result += 4;
                    if(row> 0 && grid[row-1][col] == 1){
                        result -= 2;
                    }
                    if(col>0 && grid[row][col-1] == 1){
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}