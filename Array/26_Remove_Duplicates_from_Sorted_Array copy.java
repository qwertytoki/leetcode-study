
class Solution {

    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            nums[pointer++] = nums[i];
        }
        return pointer;
    }
}
