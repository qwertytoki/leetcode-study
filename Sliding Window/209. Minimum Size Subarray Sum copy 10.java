
class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int total = 0;
        int result = Integer.MAX_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            current++;
            while (total >= target) {
                result = Math.min(result, current);
                total -= nums[left++];
                current--;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
