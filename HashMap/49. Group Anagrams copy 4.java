class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list: map.values()){
            result.add(list);
        }
        return result;
    }
}