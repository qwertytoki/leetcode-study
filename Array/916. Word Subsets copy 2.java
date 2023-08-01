class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // put the words1 and words2 into Array, and compare them
        int[] wordMaxCount = new int[26];
        for(String word:words2){
            int[] wordCount = count(word);
            for(int i = 0; i<26;i++){
                wordMaxCount[i] = Math.max(wordCount[i], wordMaxCount[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(String word:words1){
            boolean pass = true;
            int[] wordCount = count(word);
            for(int i= 0; i<26;i++){
                if(wordCount[i] < wordMaxCount[i]){
                    pass = false;
                    break;
                }
            }
            if(pass){
                result.add(word);
            }
        }

        return result;
    }

    private int[] count(String word){
        int[] wordArray = new int[26];
        for(char c : word.toCharArray()){
            wordArray[c - 'a']++;
        }
        return wordArray;
    }
}