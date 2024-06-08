class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] grid = new int[rowLen][colLen];
        boolean obstacle = false;
        for(int i =0; i<rowLen; i++){
            if(!obstacle && obstacleGrid[i][0]==0){
                grid[i][0] = 1;
            }else{
                grid[i][0] = 0;
                obstacle = true;
            }
        }
        obstacle = false;
        for(int i = 0; i<colLen; i++){
            if(!obstacle && obstacleGrid[0][i]==0){
                grid[0][i] = 1;
            }else{
                obstacle = true;
                grid[0][i] = 0;
            }
        }
        for(int i = 1; i<rowLen; i++){
            for(int j = 1;j<colLen; j++){
                if(obstacleGrid[i][j]==1){
                    grid[i][j] = 0;
                }else{
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
                
            }
        }
        return grid[rowLen-1][colLen-1];
    }
}