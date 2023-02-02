// something wrong

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // DFS iterative way
        if(grid == null || grid.length == 0){
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] rChange = new int[]{1,-1,0,0};
        int[] cChange = new int[]{0,0,1,-1};
        

        int max = 0;

        for(int r =0; r<grid.length; r++){
            for(int c = 0;c<grid[0].length;c++){
                if(grid[r][c] == 1 || !seen[r][c]){
                    int count = 0;
                    seen[r][c] = true;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r,c});
                    while(!stack.empty()){
                        int[] current = stack.pop();
                        count++;
                        for(int i =0;i<4;i++){
                            int newR = current[0] + rChange[i];
                            int newC = current[1] + cChange[i];
                            if(newR>=0 && newC >= 0 && newR<grid.length && newC < grid[0].length 
                            && grid[newR][newC] == 1 && !seen[newR][newC]){
                                seen[newR][newC] = true;
                                stack.push(new int[]{newR,newC});
                            }
                        }
                    }
                    max = Math.max(count,max);
                }
            }
        }

        return max;
    }
}