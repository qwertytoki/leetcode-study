class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length ==0){
            return;
        }
        int swapPoint = nums.length-2;
        while(swapPoint >=0 && nums[swapPoint] >= nums[swapPoint+1]){
            swapPoint--;
        }
        if(swapPoint >= 0){
            int swapTarget = nums.length-1;
            while(nums[swapPoint]>=nums[swapTarget]){
                swapTarget--;
            }
            swap(nums, swapPoint, swapTarget);
        }
        
        reverse(nums, swapPoint+1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start <= end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}