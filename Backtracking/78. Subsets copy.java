class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //1 結果を入れる用の本リストを作成、empty listを入れる
        //2 numsで繰り返し、 仮リスト作成
        //3 本リストでFor文回して仮リストに、本リスト+num のリストを追加する
        //4 本リストに仮リストの要素をすべて追加する
        List<List<Integer>> outputList = new ArrayList<>();
        outputList.add(new ArrayList<Integer>());
        for(int num:nums){
            List<List<Integer>> tempList = new ArrayList<>();
            for(List<Integer> output:outputList){
                List<Integer> list = new ArrayList<>(output);
                list.add(num);
                tempList.add(list);
            }
            for(List<Integer> temp:tempList){
                outputList.add(temp);
            }
        }

        return outputList;
    }
}