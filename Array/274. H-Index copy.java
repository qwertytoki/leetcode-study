
class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= len) {
                return len;
            }
            len--;
        }
        return 0;
    }
}
