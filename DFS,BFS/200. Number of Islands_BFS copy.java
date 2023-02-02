class Solution {
    //BFS
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        int rEdge = grid.length;
        int cEdge = grid[0].length;
        int count = 0;

        for(int row = 0; row< rEdge; row++){
            for(int col = 0; col< cEdge; col++){
                if(grid[row][col]=='1'){
                    count++;
                    grid[row][col] = '0';
                    Queue<Integer> island = new LinkedList<>();
                    island.add(row * cEdge + col);  // このやり方が全然しっくりこない.
                    // cEdgeで割るとrが、mod取るとcが出る、という数値のことらしい。
                    while(!island.isEmpty()){
                        int current = island.poll();
                        int r = current / cEdge;
                        int c = current % cEdge;
                        if(r - 1 >=0 && grid[r-1][c] == '1'){
                            island.add((r-1)*cEdge+c);
                            grid[r-1][c] = '0';
                        }
                        if(r + 1 <rEdge && grid[r+1][c] == '1'){
                            island.add((r+1)*cEdge+c);
                            grid[r+1][c] = '0';
                        }
                        if(c - 1 >=0 && grid[r][c-1] == '1'){
                            island.add(r*cEdge+(c-1));
                            grid[r][c-1] = '0';
                        }
                        if(c + 1 <cEdge && grid[r][c+1] == '1'){
                            island.add(r*cEdge+(c+1));
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}