class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int left= 0;
        int right = nums.length-1;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]%2==0){
                result[left]=nums[i];
                left++;
            }else{
                result[right]=nums[i];
                right--;
            }
        }
        return result;
    }
}