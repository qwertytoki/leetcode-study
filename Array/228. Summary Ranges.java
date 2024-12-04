
class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.size() == 0) {
                list.add(num);
                continue;
            }
            int listEnd = list.get(list.size() - 1);
            if (num - 1 != listEnd) {
                result.add(generateString(list.get(0), listEnd));
                list = new ArrayList<>();
            }
            list.add(num);
        }
        if (list.size() != 0) {
            result.add(generateString(list.get(0), list.get(list.size() - 1)));
        }
        return result;
    }

    private String generateString(int a, int b) {
        if (a == b) {
            return Integer.toString(a);
        }
        return a + "->" + b;
    }
}
