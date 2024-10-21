class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            List<String> list;
            if(map.containsKey(key)){
                list = map.get(key);
            }else{
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList(map.values());
    }
}