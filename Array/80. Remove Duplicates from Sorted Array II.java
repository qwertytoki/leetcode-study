
class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int pointer = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[pointer - 1] == nums[i] && nums[pointer - 2] == nums[i]) {
                continue;
            }
            nums[pointer] = nums[i];
            pointer++;
        }
        return pointer;
    }
}
