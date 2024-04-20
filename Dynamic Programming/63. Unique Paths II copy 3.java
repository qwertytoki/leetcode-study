class Solution {
    int[][] obstacleGrid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] grid = new int[rowLen][colLen];
        if(obstacleGrid[0][0]==1){
            return 0;
        }else{
            grid[0][0] = 1;
        }
        for(int i=1;i<rowLen;i++){
            grid[i][0] = (obstacleGrid[i][0]==1) ? 0 :1; 
            if(obstacleGrid[i][0]==1){
                break;
            }
        }
        for(int i =1; i<colLen;i++){
            grid[0][i] = (obstacleGrid[0][i]==1) ? 0 : 1;
            if(obstacleGrid[0][i]==1){
                break;
            }
        }
        
        for(int i = 1; i< rowLen; i++){
            for(int j = 1; j <colLen; j++){
                grid[i][j] = obstacleGrid[i][j] == 1 ? 0 : grid[i-1][j]+grid[i][j-1];
            }
        }

        return grid[rowLen-1][colLen-1];
    }

    
    
}