
class Solution {

    // O(1) solution
    public int[] productExceptSelf(int[] nums) {
        int[] preArr = new int[nums.length];
        preArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            preArr[i] = preArr[i - 1] * nums[i - 1];
        }
        int sufVal = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sufVal = sufVal * nums[i + 1];
            preArr[i] *= sufVal;
        }
        return preArr;
    }
}
