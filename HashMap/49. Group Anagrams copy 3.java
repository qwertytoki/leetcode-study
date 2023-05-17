class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //先に全部をソートして、それで比べればいいか？
        Map<String, List<String>> anaMap = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            if(anaMap.containsKey(sortedStr)){
                anaMap.get(sortedStr).add(str);
            }else{
                List<String> list = new ArrayList();
                list.add(str);
                anaMap.put(sortedStr, list);
            }
        }
        List<List<String>> result = new ArrayList();
        for(String key:anaMap.keySet()){
            result.add(anaMap.get(key));
        }
        return result;
    }
}
