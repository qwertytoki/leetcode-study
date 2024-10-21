class Solution {
    public boolean isSubsequence(String s, String t) {
        int current =0;
        for(int i =0; i<s.length();i++){
            char sc = s.charAt(i);
            boolean find = false;
            for(int j = current; j<t.length(); j++){
                char tc = t.charAt(j);
                if(sc == tc){
                    current = j+1;
                    find = true;
                    break;
                }
            }
            if(find == false){
                return false;
            }
        }
        return true;
    }
}