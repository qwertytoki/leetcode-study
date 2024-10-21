class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; 
        int min = Integer.MAX_VALUE;
        int current = 0;
        for(int right = 0; right< nums.length; right++){
            current+= nums[right];
            while(current>= target){
                min = Math.min(min, right-left+1);
                current -= nums[left++];
            }
        }
        return min==Integer.MAX_VALUE? 0 : min;
    }
}