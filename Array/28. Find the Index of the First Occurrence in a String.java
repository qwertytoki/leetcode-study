
class Solution {

    public int strStr(String haystack, String needle) {
        int nee = needle.length();
        int hay = haystack.length();

        for (int windowStart = 0; windowStart <= hay - nee; windowStart++) {
            for (int i = 0; i < nee; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }
                if (i == nee - 1) {
                    return windowStart;
                }
            }
        }
        return -1;
    }
}
