
class Solution {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int num : nums) {
            if (candidate == num) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count++;
                    candidate = num;
                }
            }
        }
        return candidate;
    }
}
