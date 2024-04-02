class Solution {
    public int countComponents(int n, int[][] edges) {
        //1 隣接リストを作成する
        //2 visited arrayを作成し、通ったら色をつける
        int count = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] connectedList = new List[n];
        for(int i=0;i<n;i++){
            connectedList[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length;i++){
            connectedList[edges[i][0]].add(edges[i][1]);
            connectedList[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(connectedList,visited,i);
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] connectedList,boolean[] visited, int start){
        visited[start] = true;
        for(int i =0; i<connectedList[start].size();i++){
            if(!visited[connectedList[start].get(i)]){
                dfs(connectedList,visited,connectedList[start].get(i));
            }
        }
    }
}