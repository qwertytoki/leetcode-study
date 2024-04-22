class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] grid = new int[row][col];
        grid[0][0] = 1;
        for(int i = 1; i< row; i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            grid[i][0] = 1;
        }
        for(int i =1; i < col; i++){
            if(obstacleGrid[0][i]==1){
                break;
            }
            grid[0][i]= 1;
        }

        for(int i =1; i<row;i++){
            for(int j = 1; j<col; j++){
                grid[i][j] = obstacleGrid[i][j]== 1 ? 0 : grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[row-1][col-1];
        
    }
}