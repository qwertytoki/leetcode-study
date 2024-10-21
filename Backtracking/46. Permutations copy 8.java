class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result){
        if(nums.length == current.size()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int num:nums){
            if(!current.contains(num)){
                current.add(num);
                backtrack(nums, current, result);
                current.remove(current.size()-1);
            }
        }
    }
}