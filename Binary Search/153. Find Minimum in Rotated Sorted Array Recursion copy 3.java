class Solution {
    int[] nums; 
    public int findMin(int[] nums) {
        this.nums = nums;
        if(nums.length ==1)return nums[0];
        return binarySearch(0, nums.length-1);
    }

    private int binarySearch(int left, int right){
        if(left>=right){
            return nums[left];
        }
        int mid = (left+right)/2;
        if(nums[mid]>nums[right]){
            return binarySearch(mid+1,right);
        }else{
            return binarySearch(left, mid);
        }
    }
}