class Solution {
    public int islandPerimeter(int[][] grid) {
        //最初に4足して、縦に隣接してる島があったら−2、横も−2する

        int rowEnd = grid.length;
        int colEnd = grid[0].length;
        int result = 0;
        for(int row =0; row<rowEnd;row++){
            for(int col =0; col<colEnd;col++){
                if(grid[row][col] == 1){
                    result += 4;
                    if(row>0 && grid[row-1][col]==1){
                        result-=2;
                    }
                    if(col>0 && grid[row][col-1]==1){
                        result-=2;
                    }
                }
            }
        }
        return result;
    }
}

// time: O(row*col)
// space: O(1)