class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int remain, int start,  List<Integer> current, List<List<Integer>> result){
        if(remain == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(remain <0){
            return;
        }

        for(int i = start; i<nums.length; i++){
            int num = nums[i];
            current.add(num);
            backtrack(nums, remain-num, i, current, result);
            current.remove(current.size()-1);
        }

    }
}