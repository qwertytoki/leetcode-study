class Solution {
    String s,t;
    public boolean isSubsequence(String s, String t) {
        this.s = s;
        this.t = t;

        return subsequenceCheck(0,0);
    }

    private boolean subsequenceCheck(int sIndex, int tIndex){
        if(sIndex == s.length()){
            return true;
        }
        if(tIndex == t.length()){
            return false;
        }

        if(s.charAt(sIndex) == t.charAt(tIndex)){
            sIndex++;
        }
        tIndex++;

        return subsequenceCheck(sIndex,tIndex);
    }
}