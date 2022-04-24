class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right= nums.length-1;
        
        while(left<right){
            if(nums[left] %2 == 0){
                left++;
            }else{
                int a = nums[right];
                nums[right] = nums[left];
                nums[left] = a;
                right--;
            }
        }
        return nums;
    }
}