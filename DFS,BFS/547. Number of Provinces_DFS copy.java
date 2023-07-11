class Solution {
    public int findCircleNum(int[][] isConnected) {
        int rowEnd = isConnected.length;
        int result = 0;
        boolean[] seen = new boolean[rowEnd];
        for(int row=0;row<rowEnd;row++){
            if(!seen[row]){
                result++;
                dfs(isConnected,seen,row);
            }
        }
        return result;
    }
    private void dfs(int[][] isConnected,boolean[]seen, int row){
        seen[row] = true;
        int colEnd = isConnected[0].length;
        for(int col=0; col<colEnd; col++){
            if(!seen[col] && isConnected[row][col]==1){
                dfs(isConnected,seen,col);
            }
        }
    }

}