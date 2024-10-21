class Solution {
    public void nextPermutation(int[] nums) {
        // find first smaller position from right
        // find first bigger position from right
        // swap
        // reorder from swap positon to end

        int n = nums.length-1;
        int swapPoint = -1;
        for(int i =n-1; i>=0; i--){
            if(nums[i]<nums[i+1]){
                swapPoint = i;
                break;
            }
        }
        if(swapPoint>=0){
            for(int i =n; i>=0;i--){
                if(nums[swapPoint]<nums[i]){
                    swap(swapPoint, i, nums);
                    break;
                }
            }
        }
        reverse(swapPoint+1, n, nums);
    }

    private void reverse(int a, int b, int[]nums){
        while(a<b){
            swap(a++,b--,nums);
        }
    }
    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}