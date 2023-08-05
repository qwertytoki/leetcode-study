class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //ソートして、同じ組み合わせがあったら避ける。 
        //backtrack
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        helper(resultList, currentList, nums,0);
        return resultList;
    }

    private void helper(List<List<Integer>> resultList, List<Integer> currentList, int[] nums, int index){
        resultList.add(new ArrayList<>(currentList));
        for(int i = index; i<nums.length; i++){
            //if the value is same as previous, skip.
            if(i != index && nums[i-1] == nums[i]){
                continue;
            }
            currentList.add(nums[i]);
            helper(resultList, currentList, nums, i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}