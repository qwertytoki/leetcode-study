
class Solution {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                result.add(genRange(start, nums[i]));
                start = nums[i + 1];
            }
        }
        result.add(genRange(start, nums[nums.length - 1]));

        return result;
    }

    private String genRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return start + "->" + end;
    }
}
