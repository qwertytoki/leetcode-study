class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int index1= 0, index2 =0;
        while(index1<len1 || index2<len2){
            if(index1<len1){
                sb.append(word1.charAt(index1++));
            }
            if(index2<len2){
                sb.append(word2.charAt(index2++));
            }
        }

        return sb.toString();
    }
}