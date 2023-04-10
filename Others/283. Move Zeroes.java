class Solution {
    public void moveZeroes(int[] nums) {
        //0の数を記録して、左にずらす
        //0の数だけみぎに0を足す。
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