
class Solution {

    public int jump(int[] nums) {
        int currRange = 0;
        int jump = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            jump = Math.max(jump, i + nums[i]);
            if (currRange == i) {
                currRange = jump;
                count++;
            }
        }
        return count;
    }
}
