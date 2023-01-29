class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 0 edge case
        // 1 sort the String 
        // 2 put sorted value as key, value as Value of Map<String, List<String>>
        // 3 return values

        // 0
        if(strs.length==0){
            return new ArrayList<>();
        }
        
        Map<String, List<String>> resultMap = new HashMap<>();
        for(String str : strs){
            //1 
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String sorted = String.valueOf(cArray); //Nlog(N)
            
            //2
            if(!resultMap.containsKey(sorted)){
                resultMap.put(sorted, new ArrayList<>());
            }
            resultMap.get(sorted).add(str);
        }
        //3
        return new ArrayList<>(resultMap.values());
    }
}