class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //Backtracking is an algorithm for finding all solutions by exploring all potential candidates.
        List<List<Integer>> output = new LinkedList();
        List<Integer> numsList = new ArrayList<>();
        for(int num:nums){
            numsList.add(num);
        }
        int n = nums.length;
        backtrack(n,numsList,output,0);
        return output;
    }

    private void backtrack(int n, List<Integer> nums, List<List<Integer>> output,int first){
        if(first == n){
            output.add(new ArrayList<Integer>(nums));
        }
        for(int i= first; i<n;i++){
            Collections.swap(nums,first,i);
            backtrack(n,nums,output,first+1);
            Collections.swap(nums,first,i);
        }
    }
}

// Time : O(N*N!) For文でN回 * 各順列を作る操作はN!
// Space: O(N) 