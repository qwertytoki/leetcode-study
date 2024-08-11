class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()<str2.length()){
            gcdOfStrings(str2, str1);
        }
        String result = "";
        for(int i =1; i<=str2.length();i++){
            String word = str2.substring(0,i);
            if(isValid(word, str1) && isValid(word, str2)){
                result = word;
            }
        }
        return result;
    }

    private boolean isValid(String word, String target){
        int wordLen = word.length();
        int targetLen = target.length();
        int division = targetLen/wordLen;
        String candidate = "";
        for(int i = 0; i <division; i++){
            candidate+=word;
        }
        return candidate.equals(target);
    }
}