class Solution {
    public void moveZeroes(int[] nums) {
        int point1 = 0;
        for(int i = 0; i< nums.length;i++){
            if(nums[i] == 0){
                continue;
            }else{
                nums[point1] = nums[i];
                point1++;
            }
        }
        for(int i = point1; i<nums.length;i++){
            nums[i]=0;
        }
    }
}