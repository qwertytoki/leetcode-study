class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        int odd = nums.length-1;
        int pointer = 0;
        
        while(even<odd){
            if(nums[pointer]%2==0){
                nums[even]=nums[pointer];
                even++;
            }else{
                while(odd>=0 && nums[odd]%2==1){
                    odd--;
                }
                if(odd<0){
                    return nums;
                }else{
                    int i = nums[odd];
                    nums[odd]=nums[pointer];
                    nums[pointer]=nums[odd];
                    odd--;
                }
            }
            pointer++;
        }
        return nums;
    }
}