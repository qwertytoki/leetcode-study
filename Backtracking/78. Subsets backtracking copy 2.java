//start endを操作しながら進んでいく

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtrack(nums, 0, size, result, new ArrayList<>());
        }
        return result;
    }

    private void backtrack(int[] nums, int start, int size, 
        List<List<Integer>> result, List<Integer> current) {
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, size, result, current);
            current.remove(current.size() - 1);
        }
    }
}