
class Solution {

    public int jump(int[] nums) {
        int count = 0;
        int currentFar = 0;
        int currentJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentFar = Math.max(currentFar, i + nums[i]);
            if (i == currentJump) {
                count++;
                currentJump = currentFar;
            }
        }
        return count;
    }
}
