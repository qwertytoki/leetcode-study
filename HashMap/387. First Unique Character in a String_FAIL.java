class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> charMap = new HashMap<>(); 
        for(char c: s.toCharArray()){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c) +1);
            }else{
                charMap.put(c,1);
            }
        }
        int idx = 0;
        for(char c : charMap.keySet()){
            if(charMap.get(c) == 1){
                return idx;
            }
            idx++;
        }
        
        return 0;
    }
}