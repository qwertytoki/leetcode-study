class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int sIndex = 0;
        for(int i = 0; i< tArr.length; i++){
            if(sIndex == sArr.length){
                return true;
            }
            if(sArr[sIndex] == tArr[i]){
                sIndex++;
            }
        } 
        if(sIndex == sArr.length){
            return true;
        }
        return false;
    }
}