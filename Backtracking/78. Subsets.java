class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int num: nums){
            List<List<Integer>> newSubsets = new ArrayList();
            for(List<Integer> curr:output){
                ArrayList<Integer> newList = new ArrayList<>(curr);
                newList.add(num);
                newSubsets.add(newList);
            }
            for(List<Integer> curr: newSubsets){
                output.add(curr);
            }
        }
        return output;
    }
}