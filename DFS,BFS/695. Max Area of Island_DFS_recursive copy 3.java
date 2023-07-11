class Solution {
    int[][] grid;
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int rowEnd = grid.length;
        int colEnd = grid[0].length;
        int result = 0;
        seen = new boolean[rowEnd][colEnd];
        for(int row =0;row<rowEnd;row++){
            for(int col=0;col<colEnd;col++){
                result = Math.max(result, count(row,col));
            }
        }
        return result;
    }

    private int count(int row, int col){
        int rowEnd = grid.length;
        int colEnd = grid[0].length;
        if(row<0||col<0||row>=rowEnd||col>=colEnd||grid[row][col]==0||seen[row][col]){
            return 0;
        }
        seen[row][col] = true;
        return 1 + count(row-1,col)+ count(row+1,col)+ count(row,col-1)+ count(row,col+1);
    }

}

