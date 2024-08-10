class Solution {
    public void nextPermutation(int[] nums) {
        int swapPoint = -1;
        int n = nums.length-1;
        for(int i = n-1; i>=0; i--){
            if(nums[i]<nums[i+1]){
                swapPoint = i;
                break;
            }
        }
        if(swapPoint >=0){
            for(int i = n; i>=swapPoint; i--){
                if(nums[swapPoint]<nums[i]){
                    swap(swapPoint, i, nums);
                    break;
                }
            }
        }
        reverse(swapPoint+1, n, nums);
    }

    private void reverse(int left, int right, int[] nums){
        while(left< right){
            swap(left++, right--, nums);
        }
    }

    private void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}