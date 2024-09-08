
class Solution {

    public int maximalSquare(char[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxSize = 0;
        int dp[][] = new int[rowLen][colLen];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == '1') {
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row][col - 1], dp[row - 1][col])) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[row][col]);
                }
            }
        }
        return maxSize * maxSize;
    }
}
