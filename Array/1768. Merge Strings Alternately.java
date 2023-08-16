class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] charArr = new char[word1.length() + word2.length()];
        int longerLen = Math.max(word1.length(), word2.length());
        int index = 0;
        char[] word1c = word1.toCharArray();
        char[] word2c = word2.toCharArray();
        for(int i = 0; i<longerLen; i++){
            if(i < word1.length()){
                charArr[index] = word1c[i];
                index++;
            }
            if(i < word2.length()){
                charArr[index] = word2c[i];
                index++;
            }
        }
        return String.valueOf(charArr);
    }
}