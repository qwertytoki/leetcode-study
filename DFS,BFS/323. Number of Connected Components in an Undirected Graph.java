// 今までの問題の中で一番難しかった。。回答見ても理解するのに時間がかかった

class Solution {
    // adjListは、同じグループ内の要素を含んだ配列。 厳密にはadjListArray
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode){
        visited[startNode] = 1; //到達済にする
        for(int i =0;i<adjList[startNode].size(); i++){
            if(visited[adjList[startNode].get(i)] == 0){ //次のnodeがまだ未到達だったらそこも到達済に
                dfs(adjList, visited,adjList[startNode].get(i));
            }
        }
    }
                   
    public int countComponents(int n, int[][] edges) {
        int components = 0; //これが最後に返す数になる
        int[] visited = new int [n];
        
        List<Integer>[] adjList = new ArrayList[n]; 
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;       
    }
}