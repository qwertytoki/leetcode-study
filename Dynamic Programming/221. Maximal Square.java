
class Solution {

    public int maximalSquare(char[][] matrix) {
        int count = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[][] dp = new int[rowLen][colLen];
        int maxLen = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == '1') {
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        dp[row][col] = Math.min(dp[row - 1][col], Math.min(dp[row][col - 1], dp[row - 1][col - 1])) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[row][col]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
