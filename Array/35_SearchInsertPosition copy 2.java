class Solution {
    int[] nums;
    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        return binarySearch(0, nums.length-1, target);
    }

    private int binarySearch(int left, int right, int target){
        if(left>right){
            return left;
        }
        int mid = (left+right)/2;
        if(nums[mid]== target) return mid;
        if(nums[mid]>target){
            return binarySearch(left, mid-1, target);
        }else{
            return binarySearch(mid+1, right, target);
        }
    }

}