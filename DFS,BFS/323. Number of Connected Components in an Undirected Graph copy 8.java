class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] cList = new ArrayList[n];
        for(int i =0; i<n; i++){
            cList[i] = new ArrayList<>();
        }
        for(int i =0; i< edges.length; i++){
            cList[edges[i][0]].add(edges[i][1]);
            cList[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];

        for(int i = 0; i< n; i++){
            if(!visited[i]){
                count++;
                helper(cList, visited, i);
            }
        }

        return count;
    }

    private void helper(List<Integer>[] cList, boolean[] visited, int index){
        visited[index] = true;
        for(int adj : cList[index]){
            if(!visited[adj]){
                helper(cList, visited, adj);
            }
        }
    }
}