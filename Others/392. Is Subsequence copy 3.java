class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int sIndex = 0;
        for(int i = 0; i<tChar.length; i++){
            if(sIndex == s.length()){
                return true;
            }
            if(tChar[i] == sChar[sIndex]){
                sIndex++;
            }
        }
        return sIndex == s.length();
    }
}