class Solution {
    public int countComponents(int n, int[][] edges) {
        int component = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] compoArray = new ArrayList[n];

        for(int i=0; i<n;i++){
            compoArray[i] = new ArrayList<>();
        }

        for(int i =0; i< edges.length; i++){
            compoArray[edges[i][0]].add(edges[i][1]);
            compoArray[edges[i][1]].add(edges[i][0]);
        }

        for(int i = 0; i< n;i++){
            if(!visited[i]){
                
                component++;
                dfs(compoArray, visited, i);
            }
        }


        return component;
    }

    private void dfs(List<Integer>[] compoArray, boolean[] visited, int start){
        visited[start] = true;
        for(int i:compoArray[start]){
            if(!visited[i]){
                dfs(compoArray, visited, i);
            }
        }
    }
}