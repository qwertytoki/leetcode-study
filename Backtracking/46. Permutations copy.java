class Solution {
    // いまだに全然わかってない。
    // 再帰を使って解く。 numsを1つずつ順番にswapしながら、さらにbacktrackを呼んでいく
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> numsList = new ArrayList<>();
        for(int num:nums){
            numsList.add(num);
        }
        backtrack(nums.length,numsList, output, 0);
        return output;

    }

    private void backtrack(int length, List<Integer> nums, List<List<Integer>> output, int first){
        if(first == length){
            output.add(new ArrayList<Integer>(nums));
        }
        for(int i = first; i<length;i++){
            Collections.swap(nums,first, i);
            backtrack(length,nums,output, first+1);
            Collections.swap(nums, i, first);
        }
    }
}