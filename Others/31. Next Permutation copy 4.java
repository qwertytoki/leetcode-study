class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length-1;
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums, i,j);
        }
        reverse(nums, i+1, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}