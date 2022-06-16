class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // maybe hashmap, put the "word" to key, and value will be the words contains key's all char(s).
        
        if(strs == null || strs.length == 0 ){
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s :strs){
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
            
        }
        return new ArrayList<>(map.values());
    }
}