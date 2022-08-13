class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subNums = new ArrayList<>();
        int index = 0;
        int minValIndex = minValIndex(nums, index, Integer.MAX_VALUE);
        index = minValIndex +1;
        subNums.add(nums[minValIndex]);
        while(index < nums.length){
            minValIndex = minValIndex(nums, index, nums[index]);
            if(minValIndex == -1) break;
            subNums.add(nums[minValIndex]);
            index = minValIndex+1;
        }
        return subNums.size();
    }
    
    private int minValIndex(int[] nums, int start, int minVal){
        int minIndex = -1;
        for(int i =start;i<nums.length; i++ ){
            if(nums[i] < minVal){
                minVal = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}