class Solution {
    public int firstUniqChar(String s) {
        // 1st loop put map and count
        // 2nd loop find count ==1 
        // 3rd loop find and return the value or -1

        //1
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        char[] sArray = s.toCharArray();
        for(char c : sArray){
            int count = charCountMap.getOrDefault(c, 0);
            charCountMap.put(c, count +1);
        }
        //2 
        char unique = ' ';
        for(char key: charCountMap.keySet()){
            if(charCountMap.get(key)==1){
                unique = key; 
                break;
            }
        }
        //3
        if(unique == ' '){
            return -1;
        }
        for(int i = 0; i<sArray.length; i++){
            if(sArray[i] == unique){
                return i;
            }
        }
        return -1;
    }
}