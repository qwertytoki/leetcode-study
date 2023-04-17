class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n-1;
        // [1]
        while(pivot >= 1 && nums[pivot] <= nums[pivot-1]){
            pivot--;
        }
        //pivot point がみつかれば、がpivotする相手を探す
        //※すでに[1]で、pivot point以降はdescになってることがわかっている
        if(pivot != 0){
            int i = n-1;
            while(nums[pivot-1]>=nums[i]){
                i--;
            }
            swap(nums, pivot-1, i);
        }

        //pivot pointより先の値を並び替えていく。
        //※すでに[1]で、pivot point以降はdescになってることがわかっている
        int left = pivot;
        int right = n-1;
        while(left < right){
            swap(nums, left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}