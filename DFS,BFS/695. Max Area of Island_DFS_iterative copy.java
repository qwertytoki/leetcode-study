class Solution {

    
    public int maxAreaOfIsland(int[][] grid) {
        int[] rowArea = new int[]{1,-1,0,0};
        int[] colArea = new int[]{0,0,1,-1};
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] seen = new boolean[m][n];
        int result = 0;
        for(int r = 0; r<m;r++){
            for(int c = 0; c<n; c++){
                if(!seen[r][c] && grid[r][c] == 1){
                    int current = 0;
                    LinkedList<int[]> stack = new LinkedList<>();
                    stack.add(new int[]{r,c});
                    seen[r][c] = true;
                    while(!stack.isEmpty()){
                        int[] rc =  stack.pollLast();
                        int row = rc[0];
                        int col = rc[1];
                        current++;
                        for(int i =0; i<4;i++){
                            int newR = row + rowArea[i];
                            int newC = col + colArea[i];
                            if(newR>=0 && newR < m && newC >= 0 && newC<n &&grid[newR][newC]==1 && !seen[newR][newC]){
                                stack.add(new int[]{newR,newC});
                                seen[newR][newC] = true;
                            }
                        }
                    }
                    result = Math.max(result, current);
                }
            }
        }
        return result;
    }

}