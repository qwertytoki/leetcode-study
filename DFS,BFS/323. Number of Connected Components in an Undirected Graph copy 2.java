class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i =0; i<edges.length;i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i =0;i<n;i++){
            if(!visited[i]){
                result++;
                dfs(adjList,visited,i);
            }
        }
        return result;   
    }

    private void dfs(List<Integer>[] adjList, boolean[]visited, int start){
        visited[start] = true;
        for(int neighbor : adjList[start]){
            if(visited[neighbor] == false){
                dfs(adjList, visited, neighbor);
            }
        }
    }
}