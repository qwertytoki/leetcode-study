class Solution {
    public int search(int[] nums, int target) {
        //1 find min_point
        //2 binary search left~min_point-1
        //3 binary search min_point~right

        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        //1 
        int left = 0;
        int right = nums.length-1;
        int minPoint = nums[0];
        while(left<=right){
            int mid = right + (left - right)/2;
            if(mid < right && nums[mid+1] < nums[mid] ){
                minPoint = mid+1;
                break;
            }
            if(mid > left && nums[mid-1]>nums[mid]){
                minPoint = mid;
                break;
            }

            if(nums[mid]<nums[right]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        //2
        if(minPoint == 0){
            return binarySearch(nums,0,nums.length-1,target);
        }
        int result = binarySearch(nums, 0, minPoint-1, target);
        if(result != -1){
            return result;
        }
        //3
        return binarySearch(nums,minPoint, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target){
    
        while(left <= right){
            int mid = right + (left - right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}