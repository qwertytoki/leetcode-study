class Solution {
    // Cascading
    // 一つずつ順番に足していく方式
    // 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int subsetSize = 0;
        for(int i = 0; i< nums.length; i++){
            int startingIndex = (i >= 1 && nums[i] == nums[i-1]) ? subsetSize :0;
            subsetSize = subsets.size();
            for(int j = startingIndex; j<subsetSize; j++){
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}