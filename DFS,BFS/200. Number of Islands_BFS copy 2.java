class Solution {
    //BFS

    //1 prepare r and c edge, for loop r and c.
    //2 in the loop, if it found 1, make queue and put r,c
    //3 while queue is not empty, verify r+- and c+-.
    //4 return count
    public int numIslands(char[][] grid) {
        //1
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rEdge = grid.length;
        int cEdge = grid[0].length;
        int count = 0;
        for(int r = 0;r<rEdge;r++){
            for(int c = 0; c<cEdge;c++){
                if(grid[r][c] == '1'){
                    //2
                    count++;
                    Queue<Integer> island = new LinkedList<>();
                    island.add(r*cEdge + c);
                    while(!island.isEmpty()){
                        //3
                        int current = island.poll();
                        int row = current / cEdge;
                        int col = current % cEdge;
                        if(row-1 >= 0 && grid[row-1][col] == '1'){
                            grid[row-1][col] = '0';
                            island.add((row-1) * cEdge + col);
                        }
                        if(row+1 < rEdge && grid[row+1][col] == '1'){
                            grid[row+1][col] = '0';
                            island.add((row+1) * cEdge + col);
                        }
                        if(col-1 >= 0 && grid[row][col-1] == '1'){
                            grid[row][col-1] = '0';
                            island.add((row) * cEdge + col-1);
                        }
                        if(col+1 < cEdge && grid[row][col+1] == '1'){
                            grid[row][col+1] = '0';
                            island.add((row) * cEdge + col+1);
                        }
                    }
                }
            }
        }

        //4
        return count;
    }
}