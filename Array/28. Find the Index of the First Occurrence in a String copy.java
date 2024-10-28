
class Solution {

    public int strStr(String haystack, String needle) {
        int hay = haystack.length();
        int nee = needle.length();

        for (int h = 0; h <= hay - nee; h++) {
            for (int n = 0; n < nee; n++) {
                if (haystack.charAt(h + n) != needle.charAt(n)) {
                    break;
                }
                if (n == nee - 1) {
                    return h;
                }
            }
        }

        return -1;
    }
}
