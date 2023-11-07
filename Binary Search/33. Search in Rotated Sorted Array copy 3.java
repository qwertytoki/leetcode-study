class Solution {
    public int search(int[] nums, int target) {
        // find rotation and find the target
        if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){ // find the smallest
            int mid = (left + right)/2;
            if(nums[mid] > nums[nums.length-1]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        
        int answer = binarySearch(nums, 0, left-1, target);
        if(answer != -1){
            return answer;
        }else{
            return binarySearch(nums, left, nums.length-1, target);
        }
        
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int mid = (left + right) /2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > target){
            return binarySearch(nums, left, mid-1, target);
        }else{
            return binarySearch(nums, mid+1, right, target);
        }
    }
}