class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1 loop by strs
        //2 sort the str, and put to the map ( Map<String, List<String>>)
        //3 put to the map 
        //4 return values
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str:strs){
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String sorted = String.valueOf(cArray);
            if(groupMap.get(sorted) == null){
                groupMap.put(sorted, new ArrayList<String>());
            }
            groupMap.get(sorted).add(str);
        }
        return new ArrayList(groupMap.values());
    }
}