class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), result, nums);
        return result;
    }

    private void backtrack(List<Integer> current, List<List<Integer>> result, int[] nums){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int num : nums){
            if(!current.contains(num)){
                current.add(num);
                backtrack(current, result, nums);
                current.remove(current.size()-1);    
            }
            
        }

    }
}