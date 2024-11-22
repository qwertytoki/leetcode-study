
class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.le
            ≈ngth()
        
        ≈);
        }
        for (int i = 0; i < minLen; i++) {
            String s = strs[0];
            char c = s.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String sj = strs[j];
                if (sj.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
