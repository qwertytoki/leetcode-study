class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupMap = new HashMap<>();
        for(String str : strs){
            char[] strc = str.toCharArray();
            Arrays.sort(strc);
            String sortedS = String.valueOf(strc);
            
            if(!groupMap.containsKey(sortedS)){
                groupMap.put(sortedS, new ArrayList<>());
            }
            List<String> value = groupMap.get(sortedS);
            value.add(str);
            groupMap.put(sortedS, value);
        }

        return new ArrayList(groupMap.values());
    }
}