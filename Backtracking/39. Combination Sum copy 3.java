class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        backtrack(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int remain, List<Integer> curList, int start){
        if(remain == 0){
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        if(remain < 0){
            return;
        }
        for(int i = start; i< candidates.length; i++){
            curList.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], curList, i);
            curList.remove(curList.size()-1);
        }

    }
}