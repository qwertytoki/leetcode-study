class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rowEnd = grid.length;
        int colEnd = grid[0].length;
        int number = 0;
        for(int row = 0;row< rowEnd; row++){
            for(int col = 0 ; col<colEnd;col++){
                if(grid[row][col] == '1'){
                    grid[row][col] = '0';
                    number++;
                    Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
                    queue.add(new Pair(row, col));
                    while(! queue.isEmpty()){
                        Pair<Integer, Integer> pair = queue.poll();
                        int r = pair.getKey();
                        int c = pair.getValue();
                        if(r-1 >=0 && grid[r-1][c] == '1'){
                            queue.add(new Pair(r-1, c));
                            grid[r-1][c] = '0';
                        }
                        if(r+1 <rowEnd && grid[r+1][c] == '1'){
                            queue.add(new Pair(r+1, c));
                            grid[r+1][c] = '0';
                        }
                        if(c-1 >=0 && grid[r][c-1] == '1'){
                            queue.add(new Pair(r, c-1));
                            grid[r][c-1] = '0';
                        }
                        if(c+1 <colEnd && grid[r][c+1] == '1'){
                            queue.add(new Pair(r, c+1));
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }
        return number;
    }
}