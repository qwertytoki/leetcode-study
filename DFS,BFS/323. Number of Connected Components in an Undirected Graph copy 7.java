class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i =0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adjList, visited, i);
            }
        }
        return count;
    }


    private void dfs(List<Integer>[] adjList, boolean[] visited, int start){
        visited[start] = true;
        for(int adj : adjList[start]){
            if(!visited[adj]){
                dfs(adjList,visited, adj);
            }
        }
    }
}