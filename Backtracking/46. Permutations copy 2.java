class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> numsList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            list.add(nums[i]);
        }
        permute(numsList, list, nums.length, 0);
        return numsList;
    }

    private void permute(List<List<Integer>> numsList, List<Integer> nums, int length, int first ){
        if(first == length){
            numsList.add(new ArrayList<>(nums));
        }
        for(int i = first; i< length; i++){
            Collections.swap(nums , first, i);
            permute(numsList,nums,length, first+1);
            Collections.swap(nums, i, first);
        }
    }
}