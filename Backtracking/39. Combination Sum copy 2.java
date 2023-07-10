class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        //backtrack
        //進めたり戻ったりしながら再帰処理していく
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        backtrack(candidates,target, 0, result, current);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
    List<List<Integer>> result, LinkedList<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index;i<candidates.length;i++){
            current.add(candidates[i]);
            backtrack(candidates,target-candidates[i], i, result, current);
            current.removeLast();
        }
    }
}

// time : O(N^(T/M+1)
// space: O^(T/M)