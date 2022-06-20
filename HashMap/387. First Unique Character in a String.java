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
        for(int i =0; i< charMap.keySet().size(); i++){
            if (charMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}