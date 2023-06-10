class Solution {
    public int firstUniqChar(String s) {
        // 1st loop put map and count
        // 2nd loop find and return the value or -1

        //1
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        char[] sArray = s.toCharArray();
        for(char c : sArray){
            int count = charCountMap.getOrDefault(c, 0);
            charCountMap.put(c, count +1);
        }
        //2 
        for(int i = 0; i< sArray.length;i++){
            if(charCountMap.get(sArray[i])==1){
                return i;
            }
        }
        return -1;
    }
}