class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0, zeroPointer = 0;
        for(int num:nums){
            if(num == 0){
                zeroPointer++;
            }else{
                nums[pointer] = num;
                pointer++;
            }
        }
        for(int i = nums.length-1; i >= nums.length - zeroPointer; i--){
            nums[i] = 0;
        }
    }
}