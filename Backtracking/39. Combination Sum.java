class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(target,comb,0,candidates,results);
        return results;
    }

    private void backtrack(
        int remain, LinkedList<Integer> comb,int start, int[]candidates, List<List<Integer>> results){
            if(remain == 0){
                results.add(new ArrayList<Integer>(comb));
                return;
            }
            if(remain < 0){
                return;
            }
            for(int i = start; i< candidates.length; i++){
                comb.add(candidates[i]);
                backtrack(remain-candidates[i], comb, i,candidates, results);
                comb.removeLast();
            }
        }
    
}