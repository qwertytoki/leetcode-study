class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //まずはempty setを追加したリストを作成
        //次に、リストを別で作成し、最初に作ったリストを更新した要素を入れていく
        //出来上がったものを元あるリストに追加する(説明わかりづらいな)
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