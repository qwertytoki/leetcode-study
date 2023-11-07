class Solution {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length-1);
    }

    private int findMinHelper(int[] nums, int left, int right){
        if(left>right || right >= nums.length){
            return -1;
        }
        if(nums.length ==1 || nums[left] < nums[right]){
            return nums[left];
        }
        int mid = (left + right) /2;
        if(mid <right && nums[mid]>nums[mid+1]){
            return nums[mid+1];
        }
        if(nums[mid]<nums[right]){
            return findMinHelper(nums, left, mid);
        }else{
            return findMinHelper(nums, mid+1, right);
        }
    }
    
}