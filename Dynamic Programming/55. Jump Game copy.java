
class Solution {

    public boolean canJump(int[] nums) {
        // maxReachがlengthを超えるかどうかを一つずつチェックしていく。 O(N)
        int maxReach = 0;
        int len = nums.length - 1;
        for (int i = 0; i <= len; i++) {
            if (maxReach < i) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= len) {
                return true;
            }
        }
        return false;
    }
}
