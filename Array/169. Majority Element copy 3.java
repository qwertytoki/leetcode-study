
class Solution {

    public int majorityElement(int[] nums) {
        //surely majority is there, so we only can track 1 number; 
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
