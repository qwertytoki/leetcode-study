class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int current = 0;
        for(int i = 0; i< nums.length; i++){
            int n = nums[i];
            current += n;
            while(current>=target){
                min = Math.min(min, i-left+1);
                current -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}