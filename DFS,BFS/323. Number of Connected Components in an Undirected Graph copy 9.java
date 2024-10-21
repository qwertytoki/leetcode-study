class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adjListArr = new ArrayList[n];
        for(int i =0;i<n;i++){
            adjListArr[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            adjListArr[edge[0]].add(edge[1]);
            adjListArr[edge[1]].add(edge[0]);
        }
        int count  =0;
        for(int i = 0; i< n ; i++){
            if(!visited[i]){
                count++;
                dfs(adjListArr, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] adjListArr, boolean[]visited, int index){
        visited[index]= true;
        for(int i: adjListArr[index]){
            if(!visited[i]){
                dfs(adjListArr,visited, i);
            }
        }
    }

}