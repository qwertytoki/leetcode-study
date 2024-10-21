class Solution {
    /**
    List<List<Integer>> adjListに関係性を溜め込んで
    boolean[] passedをつかってそれらをDFSで埋めていく
    上記2つを生み出すとこがキモ
     */
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] passed = new boolean[n];
        int count = 0;
        for(int i =0; i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int[] edge = edges[i];
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i< n; i++){
            if(passed[i] != true){
                count++;
                dfs(passed, adjList,i);
            }
        }
        return count;
    }

    private void dfs(boolean[] passed, List<List<Integer>> adjList, int start){
        passed[start] = true;
        for(int i : adjList.get(start)){
            if(passed[i]!= true){
                dfs(passed, adjList, i);
            }
        }
    }
}