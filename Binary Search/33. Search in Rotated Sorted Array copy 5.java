class Solution {
    int[] nums;
    public int search(int[] nums, int target) {
        this.nums = nums;
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<nums[right]){
            return binarySearch(left, right, target);
        }
        int minIndex = findMinIndex(left, right);
        if(nums[minIndex]<=target && target<=nums[right]){
            return binarySearch(minIndex, right, target);
        }else{
            return binarySearch(left, minIndex, target);
        }
    }

    private int findMinIndex(int left, int right){
        if(left>=right){
            return left;
        }
        int mid = (left+right)/2;
        if(nums[mid]>nums[right]){
            return findMinIndex(mid+1, right);
        }else{
            return findMinIndex(left, mid);
        }
    }

    private int binarySearch(int left, int right, int target){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(nums[mid]== target){
            return mid;
        }
        if(nums[mid]<target){
            return binarySearch(mid+1, right, target);
        }else{
            return binarySearch(left, mid-1, target);
        }
    }

    
}