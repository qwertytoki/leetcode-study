class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int remain, List<List<Integer>> result, int start, List<Integer> current){
        if(remain ==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(remain<0){
            return;
        }
        for(int i = start; i< nums.length; i++){
            int n = nums[i];
            current.add(n);
            backtrack(nums, remain-n, result, i,current);
            current.remove(current.size()-1);
        }
    }

}