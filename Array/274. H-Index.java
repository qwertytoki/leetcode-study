
class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations); // [0,1,3,5,6]
        int len = citations.length;
        int citationNum = len;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= citationNum) {
                return citationNum;
            }
            citationNum--;
        }
        return 0;
    }
}
