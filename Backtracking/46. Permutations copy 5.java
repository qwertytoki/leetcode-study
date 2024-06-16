class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(new ArrayList<>(), answer, nums);
        return answer;
    }

    private void backtrack(List<Integer> current, List<List<Integer>> answer, int[] nums){
        // 再帰かつ、最後にRemoveするのがbacktrackの特徴
        // 全走査が必要なときはこの手法を疑うこと
        
        if(current.size() == nums.length){
            answer.add(new ArrayList(current));
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