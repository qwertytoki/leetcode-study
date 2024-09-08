
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int maxArea = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (row < 0 || col < 0 || row >= rowLen || col >= colLen || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1) + 1;
    }
}
