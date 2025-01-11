
class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentCount = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentCount++;
                    currentNum++;
                }
                max = Math.max(max, currentCount);
            }
        }
        return max;
    }
}
