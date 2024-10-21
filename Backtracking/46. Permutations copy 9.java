class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int num:nums){
            if(!current.contains(num)){
                current.add(num);
                backtrack(nums, result, current);
                current.remove(current.size()-1);
            }
        }
    }
}