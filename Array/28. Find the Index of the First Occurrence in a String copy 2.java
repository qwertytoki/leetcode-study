
class Solution {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            char h = haystack.charAt(i);
            int neeIndex = 0;
            char n = needle.charAt(neeIndex);
            int start = i;
            while (h == n) {
                if (neeIndex == needle.length() - 1) {
                    return i;
                }
                n = needle.charAt(++neeIndex);
                if (start + 1 > haystack.length() - 1) {
                    break;
                }
                h = haystack.charAt(++start);
            }
        }
        return -1;
    }
}
