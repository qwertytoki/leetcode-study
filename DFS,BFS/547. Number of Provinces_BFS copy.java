class Solution {
    //BFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int number= 0;
        boolean[] visit = new boolean[n];
        for(int i =0;i<n;i++){
            if(!visit[i]){
                number++;
                bfs(isConnected, visit, i);
                // dfs(isConnected, visit, i);
            }
        }
        return number;
    }

    private void bfs(int[][] isConnected, boolean[] visit, int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visit[index] = true;
        while(! queue.isEmpty()){
            index  = queue.poll();
            for(int i = 0; i<isConnected.length;i++){
                if(isConnected[index][i]==1 && !visit[i]){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }


    private void dfs(int[][] isConnected, boolean[] visit, int index){
        //隣接している部分をすべてtrueに変えていく
        visit[index] = true;
        for(int i =0;i<isConnected.length; i++){
            if(isConnected[index][i]==1 && !visit[i]){
                dfs(isConnected, visit, i);
            }
        }
    }
}