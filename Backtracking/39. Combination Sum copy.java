class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combi = new LinkedList<>();
        backtrack(candidates, target, 0, result, combi);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
    List<List<Integer>> result, LinkedList<Integer> combi){
        if(target == 0){
            result.add(new ArrayList<>(combi));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i =start;i<candidates.length;i++){
            combi.add(candidates[i]);
            backtrack(candidates,target - candidates[i],i,result, combi);
            combi.removeLast();
        }
        
    }
}

// time : O(N^(T/M+1)
// space: O^(T/M)