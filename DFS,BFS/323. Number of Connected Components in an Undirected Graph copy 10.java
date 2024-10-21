class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] passed = new boolean[n];
        List<List<Integer>> connectLists = new ArrayList<>();
        for(int i = 0; i< n; i++){
            connectLists.add(new ArrayList<>());
        }
        for(int[] edge :edges){
            connectLists.get(edge[0]).add(edge[1]);
            connectLists.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int i =0; i<n;i++){
            if(passed[i]!= true){
                count++;
                dfs(passed, connectLists, i);
            }
        }
        return count;
    }

    private void dfs(boolean[] passed, List<List<Integer>>connectLists, int start){
        passed[start] = true;
        for(int i:connectLists.get(start)){
            if(passed[i] != true){
                dfs(passed,connectLists, i);
            }
        }
    }
}