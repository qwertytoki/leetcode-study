class Solution {
// x軸 y軸に1を詰めていく.真ん中は grid[i][j-1]+grid[i-1][j]となる
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        //実際はこんなことしなくても、とりあえずfillすればいいかも
        Arrays.fill(grid[0], 1);
        for(int i = 0; i< m;i++){
            grid[i][0] = 1;
        }


        for(int i =1; i<m;i++){
            for(int j =1; j<n;j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

       
}