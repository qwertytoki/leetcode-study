class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i<= nums.length; i++){
            backtrack(nums,result, i, 0, new ArrayList<>());
        }
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, int size, int start, List<Integer> current){
        if(current.size() == size){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums, result, size, i+1, current);
            current.remove(current.size()-1);
        }
    }
}