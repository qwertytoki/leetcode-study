class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(new ArrayList<>(), answer, nums);
        return answer;
    }

    public void backtrack(List<Integer> current, List<List<Integer>> answer, int[] nums){
        if(current.size() == nums.length){
            answer.add(new ArrayList<>(current));
            return;
        }
        for(int num:nums){
            if(!current.contains(num)){
                current.add(num);
                backtrack(current, answer, nums);
                current.remove(current.size()-1);
            }
        }
    }

}