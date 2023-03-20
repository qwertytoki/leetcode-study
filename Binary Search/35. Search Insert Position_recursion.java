class Solution {
    int[] nums;
    int target;
    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return search(0, nums.length-1);
    }
    
    private int search(int start, int end){
        if(start>end){
            return start; 
        }
        int mid = (start + end) /2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return search(start, mid-1);
        }else{
            return search(mid+1, end);
        }
    }
}