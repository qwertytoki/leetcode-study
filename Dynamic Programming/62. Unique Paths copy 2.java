class Solution {
    public int uniquePaths(int m, int n) {
        //右に行くのは1通り、下に行くのも1通りなので、斜めに行くには1＋1通りある
        //これを続けていくと和が求められる
        int[][] d = new int[m][n];
        for(int[] arr:d){
            Arrays.fill(arr,1);
        }
        for(int row = 1; row<m; row++){
            for(int col = 1; col<n; col++){
                d[row][col] = d[row-1][col] + d[row][col-1];
            }
        }
        return d[m-1][n-1];
    }
}
// time: O(m*n)
// space: O(m*n)