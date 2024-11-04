
class Solution {

    public void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        k = k % len;
        for (int i = len - k; i < len; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
    }
}
