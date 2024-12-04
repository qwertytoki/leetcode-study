
class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i] - 1) {
                result.add(generateString(start, nums[i - 1]));
                start = nums[i];
            }
        }
        result.add(generateString(start, nums[nums.length - 1]));
        return result;
    }

    private String generateString(int a, int b) {
        if (a == b) {
            return Integer.toString(a);
        }
        return a + "->" + b;
    }
}
