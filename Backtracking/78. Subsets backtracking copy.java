class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n,k;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for(k = 0; k<=n;k++){
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return result;
    }

    private void backtrack(int start, List<Integer> current, int[] nums){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i< n; i++){
            current.add(nums[i]);
            backtrack(i+1, current, nums);
            current.remove(current.size()-1);
        }
    }
}