class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int maxArea = 0;
        for(int r=0; r< rowLen; r++){
            for(int c=0; c<colLen; c++){
                if(grid[r][c] == 1){
                    grid[r][c] = 0;
                    Stack<Pair<Integer, Integer>> stack = new Stack<>();
                    stack.add(new Pair(r,c));
                    int current =0;
                    while(!stack.isEmpty()){
                        current++;
                        Pair<Integer,Integer> pair= stack.pop();
                        int row = pair.getKey();
                        int col = pair.getValue();
                        
                        if(row-1>=0&&grid[row-1][col]==1){
                            grid[row-1][col] = 0;
                            stack.add(new Pair(row-1,col));
                        }
                        if(row+1<rowLen&&grid[row+1][col]==1){
                            grid[row+1][col] = 0;
                            stack.add(new Pair(row+1,col));
                        }
                        if(col-1>=0&&grid[row][col-1]==1){
                            grid[row][col-1] = 0;
                            stack.add(new Pair(row,col-1));
                        }
                        if(col+1<colLen&&grid[row][col+1]==1){
                            grid[row][col+1] = 0;
                            stack.add(new Pair(row,col+1));
                        }
                    }
                    maxArea = Math.max(maxArea, current);
                }
            }
        }
        return maxArea;
    }
}