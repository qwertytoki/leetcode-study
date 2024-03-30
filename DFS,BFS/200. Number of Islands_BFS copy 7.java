class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int count = 0;
        for(int r=0; r<rowLen;r++){
            for(int c=0; c<colLen;c++){
                if(grid[r][c] == '1'){ 
                    count++;
                    Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
                    queue.add(new Pair(r,c));
                    grid[r][c] = '0';
                    while(!queue.isEmpty()){
                        Pair<Integer,Integer> pair = queue.poll();
                        int row = pair.getKey();
                        int col = pair.getValue();
                        
                        if(row-1>=0 && grid[row-1][col]=='1'){
                            queue.add(new Pair(row-1,col));
                            grid[row-1][col] = '0';
                        }
                        if(row+1<rowLen && grid[row+1][col]=='1'){
                            queue.add(new Pair(row+1,col));
                            grid[row+1][col] = '0';
                        }
                        if(col-1>=0 && grid[row][col-1]=='1'){
                            queue.add(new Pair(row, col-1));
                            grid[row][col-1] = '0';
                        }
                        if(col+1 < colLen && grid[row][col+1]=='1'){
                            queue.add(new Pair(row, col+1));
                            grid[row][col+1] = '0';
                        }
                    }
                } 
            }
        }
        return count;
    }
}