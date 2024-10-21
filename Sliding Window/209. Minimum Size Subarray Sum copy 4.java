class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int result = Integer.MAX_VALUE;
        
        int left =0;
        int right = 0;
        while(right< nums.length){
            total += nums[right];
            while(total>= target){
                result = Math.min(right-left+1, result);
                total -= nums[left];
                left++;
            }
            right++;
            
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}