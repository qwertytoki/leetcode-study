class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int num = nums[0];
        int max = nums[0];
        for(int i =1; i< nums.length; i++){
            num = nums[i];
            sum = Math.max(num, sum+num);
            max = Math.max(sum, max);
        }
        return max;
    }
}