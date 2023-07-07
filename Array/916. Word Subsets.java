//これがむずかしいのは、例題でwords2に2文字のwordが提示されていないところ

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = new int[26];
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        for(String a:A){
            int[] aCount = count(a);
            boolean isValid = true;
            for(int i=0;i<26;i++){
                if(aCount[i]<bmax[i]){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                ans.add(a);
            }
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}