class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int start = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int size =0; size<=nums.length; size++){
            backtrack(start, size, new ArrayList<>(), nums, result);    
        }
        return result;
    }

    private void backtrack(int start, int size, List<Integer> current, int[] nums, List<List<Integer>> result){
        if(current.size() == size){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i<nums.length; i++){
            current.add(nums[i]);
            backtrack(i+1,size, current, nums, result);
            current.remove(current.size()-1);
        }
    }

    
}