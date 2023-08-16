class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() > str2.length()){
            return gcdOfStrings(str2,str1);
        }

        if(!str2.startsWith(str1)){
            return "";
        }

        if(str1.isEmpty()){
            return str2;
        }

        return gcdOfStrings(str1, str2.substring(str1.length()));
    }
}

