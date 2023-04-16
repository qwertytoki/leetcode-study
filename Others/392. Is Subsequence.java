class Solution {
    public boolean isSubsequence(String s, String t) {
        // put char value and index in HashMap
        // store current index
        // if next index is not exist or under current index, return false.
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, List<Integer>> charMap = new HashMap<>();
        for(int i = 0; i<tChar.length; i++){
            if(charMap.containsKey(tChar[i])){
                charMap.get(tChar[i]).add(i);
            }else{
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                charMap.put(t.charAt(i), indices);
            }
        }
        int currIdx = -1;
        for(char c: sChar){
            if(!charMap.containsKey(c)){
                return false;
            }
            boolean isMatched = false;
            for(Integer matchIndex : charMap.get(c)){
                if(currIdx < matchIndex){
                    currIdx = matchIndex;
                    isMatched = true;
                    break;
                }
            }
            if(!isMatched){
                return false;
            }
        }
        return true;
    }
}