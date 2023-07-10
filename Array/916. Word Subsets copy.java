//これがむずかしいのは、例題でwords2に2文字のwordが提示されていないところ

// bをArray[26]に突っ込む
// aも突っ込む
// bとaを比較する


class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] aggregatedB = new int[26];
        for(String b:B){
            int[] bArray = count(b);
            for(int i=0;i<26;i++){
                aggregatedB[i] = Math.max(aggregatedB[i], bArray[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(String a :A){
            int[] aArray = count(a);
            boolean isValid = true;
            for(int i=0;i<26;i++){
                if(aggregatedB[i] > aArray[i]){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                result.add(a);
            }
        }
        return result;
    }

    private int[] count(String s){
        int[] wordCount = new int[26];
        for(char c:s.toCharArray()){
            wordCount[c-'a']++;
        }
        return wordCount;
    }
}


// time: O(A+B);
// space: O(A.length+B.length);