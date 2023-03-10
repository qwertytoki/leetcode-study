class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rLen = obstacleGrid.length;
        int cLen = obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1){
            return 0;
        }
        obstacleGrid[0][0]=1;
        for(int i =1;i<rLen;i++){
            if(obstacleGrid[i][0]==0 && obstacleGrid[i-1][0] == 1){
                obstacleGrid[i][0]=1;
            }else{
                obstacleGrid[i][0]=0;
            }
        }
        for(int i =1;i<cLen;i++){
            if(obstacleGrid[0][i]==0 && obstacleGrid[0][i-1] == 1){
                obstacleGrid[0][i]=1;
            }else{
                obstacleGrid[0][i]=0;
            }
        }
        for(int row = 1; row< rLen;row++){
            for(int col = 1; col< cLen; col++){
                if(obstacleGrid[row][col] ==0){
                    obstacleGrid[row][col] = obstacleGrid[row-1][col] + obstacleGrid[row][col-1];
                }else{
                    obstacleGrid[row][col] = 0;
                }
            }
        }
        return obstacleGrid[rLen-1][cLen-1];
    }
}