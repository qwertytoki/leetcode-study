class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int numberOfIsland = 0;
        for(int row = 0; row< maxRow; row++){
            for(int col = 0; col< maxCol; col++){
                if(grid[row][col] == '1'){
                    numberOfIsland++;
                    islandHelper(grid,row,col);
                }
            }
        }
        return numberOfIsland;
    }

    private void islandHelper(char[][] grid, int row, int col){
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        
        if(row >= maxRow || row <0 || col >= maxCol || col <0 || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        islandHelper(grid, row-1, col);
        islandHelper(grid, row+1, col);
        islandHelper(grid, row, col+1);
        islandHelper(grid, row, col-1);
    }
}