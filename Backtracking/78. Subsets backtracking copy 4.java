class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int size = 0; size<=nums.length; size++){
            backtrack(nums, result, size, 0, new ArrayList<>());    
        }
        return result;
    }

    private void backtrack(
        int[] nums, List<List<Integer>> result, int size, int start, List<Integer>current
    ){
        if(current.size() == size){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i =start;i<nums.length; i++){
            int num = nums[i];
            current.add(num);
            backtrack(nums,result,size, i+1, current);
            current.remove(current.size()-1);
        }
    }
}