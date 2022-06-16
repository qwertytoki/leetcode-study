class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // maybe hashmap, put the "word" to key, and value will be the words contains key's all char(s).
        
        Map<String, List<String> anaMap = new HashMap<>();
        
        for(int i = 0; i< strs.length();i++){
            String val = strs[i];
            Char[] valArray = val.toCharArray();
            Arrays.sort(valArray);
            String key = String.valueOf(varArray);
            if(anaMap.containsKey(key)){
                List<String> a = anaMap.get(String.valueOf(varArray));
                a.add(val);
                anaMap.put(key,a);
                    
            }else{
                anaMap.put(key,Arrays.asList(val));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key:anaMap.keyValues){
            result.add(anaMap.get(key));
        }
        return result;
    
}