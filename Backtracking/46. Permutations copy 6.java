class Solution {
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int num:nums){
            if(!current.contains(num)){
                current.add(num);
                backtrack(result, current);
                current.remove(current.size()-1);
            }
        }
    }
}