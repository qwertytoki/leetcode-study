class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        int zeroPointer = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] != 0){
                nums[pointer] = nums[i];
                pointer++;
            }else{
                zeroPointer++;
            }
        }

        for(int i= nums.length-1;i>=nums.length-zeroPointer;i--){
            nums[i] = 0;
        }
    }
}