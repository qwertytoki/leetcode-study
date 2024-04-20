class Solution {
    public int maxSubArray(int[] nums) {
        int max =Integer.MIN_VALUE;
        int current = 0;
        for(int num:nums){
            if(current<num && current >0){
                current += num;
            }else if(current<num && current <0){
                current = num;
            } else{
                current+=num;
            }
            
            if(current > max){
                max = current;
            }
        }
        return max;
    }
}