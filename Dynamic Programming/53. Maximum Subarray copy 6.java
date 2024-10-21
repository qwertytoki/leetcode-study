class Solution {
    public int maxSubArray(int[] nums) {
        // num, total, max で比較
        int current = nums[0];
        int max = nums[0];
        for(int i =1 ; i<nums.length; i++){
            int num = nums[i];
            current += num;
            current = Math.max(current, num);
            max = Math.max(current, max);
        }
        return max;
    }
}