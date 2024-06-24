class Solution {
    public int findMin(int[] nums) {
        return binarySearch(0, nums.length-1, nums);
    }

    private int binarySearch(int left, int right, int[] nums){
        if(left>= right){
            return nums[left];
        }
        int mid = (left + right)/2;
        if(nums[mid]<nums[right]){
            return binarySearch(left,mid,nums);
        }else{
            return binarySearch(mid+1, right, nums);
        }
    }
}