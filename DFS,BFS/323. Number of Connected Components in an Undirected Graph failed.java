class Solution {
    
                   
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        //1 generate adjList
        List<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i< edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        //2 count++ and call dfs if visited ==false
        for(int i = 0; i<edges.length;i++){
            if(!visited[i]){
                count++;
                dfs(adjList,visited,i);
            }
        }

        return count;
    }

    private void dfs(List<Integer>[] adjList, boolean[] visited, int startNode){
        visited[startNode] = true;
        for(int i=0;i<adjList[startNode].size();i++){
            if(!visited[adjList[startNode].get(i)]){
                dfs(adjList,visited,adjList[startNode].get(i));
            }
        }
    }
}