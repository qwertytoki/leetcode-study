class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        int sPosition = 0;
        for(int i = 0; i< tCharArr.length; i++){
            if(sPosition == s.length()){
                return true;
            }
            if(sCharArr[sPosition] == tCharArr[i]){
                sPosition++;
            }
        }
        return sPosition == s.length();
        
    }
}