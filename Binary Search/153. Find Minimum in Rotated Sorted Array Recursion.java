class Solution {
    public int findMin(int[] nums) {
        return findMinRecursive(nums, 0, nums.length - 1);
    }
    
    private int findMinRecursive(int[] nums, int left, int right) {
        // Base case: When only one element remains or the subarray is already sorted.
        if (left == right || nums[left] < nums[right]) {
            return nums[left];
        }
        
        int mid = (left + right) / 2;

        // If mid element is greater than the next one, then nums[mid + 1] is the minimum
        if (mid < right && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }

        // Decide the direction of the recursive search
        if (nums[left] > nums[mid]) {
            // Minimum is on the left side
            return findMinRecursive(nums, left, mid);
        } else {
            // Minimum is on the right side
            return findMinRecursive(nums, mid + 1, right);
        }
    }
}
