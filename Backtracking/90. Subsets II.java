//backtrack
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        subsetsWithDupHeader(subsets, currentSubset, nums, 0);
        return subsets;
    }

    private void subsetsWithDupHeader(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index){
        subsets.add(new ArrayList<>(currentSubset));
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i-1]){
                continue;
            }
            currentSubset.add(nums[i]);
            subsetsWithDupHeader(subsets, currentSubset, nums, i+1);
            currentSubset.remove(currentSubset.size() -1);
        }
    }
}