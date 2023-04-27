class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        //BFS
        int nr = grid.length;
        int nc = grid[0].length;
        int number = 0;
        
        for(int r = 0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(grid[r][c] == '1'){
                    number++;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.add(helper(r,c,nc));
                    
                    while(!queue.isEmpty()){
                        int n = queue.poll();
                        int row = n/nc;
                        int col = n%nc;
                        
                        if(row-1>=0 && grid[row-1][col]=='1'){
                            queue.add(helper(row-1,col,nc));
                            grid[row-1][col] = '0';
                        }
                        if(row+1<nr && grid[row+1][col]=='1'){
                            queue.add(helper(row+1,col,nc));
                            grid[row+1][col] = '0';
                        }
                        if(col-1>=0 && grid[row][col-1] == '1'){
                            queue.add(helper(row,col-1,nc));
                            grid[row][col-1] = '0';
                        }
                        if(col+1 < nc && grid[row][col+1] == '1'){
                            queue.add(helper(row,col+1,nc));
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return number;
    }

    private int helper(int r, int c, int nc){
        return r * nc + c;
    }
}