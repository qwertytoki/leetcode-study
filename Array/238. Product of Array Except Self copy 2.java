
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] preArr = new int[nums.length];
        int[] sufArr = new int[nums.length];

        preArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            preArr[i] = preArr[i - 1] * nums[i - 1];
        }
        sufArr[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sufArr[i] = sufArr[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            preArr[i] *= sufArr[i];
        }
        return preArr;
    }
}
