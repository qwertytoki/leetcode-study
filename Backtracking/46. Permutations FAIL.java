class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> numsList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            list.add(nums[i]);
        }
        permute(numsList, list, 0);
        return numsList;
    }

    private void permute(List<List<Integer>> numsList, List<Integer> nums, int length ){
        if(length == nums.size()){
            numsList.add(nums);
        }
        for(int i = length; i< nums.size();i++){
            Collections.swap(nums, i, length);
            permute(numsList,nums,length+1);
            Collections.swap(nums, length, i);
        }
    }
}