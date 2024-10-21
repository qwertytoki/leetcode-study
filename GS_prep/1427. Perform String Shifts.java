
class Solution {

    public String stringShift(String s, int[][] shift) {
        int shiftLeft = 0;
        for (int[] sarr : shift) {
            if (sarr[0] == 0) {
                shiftLeft += sarr[1];
            } else {
                shiftLeft -= sarr[1];
            }
        }
        int n = s.length();
        shiftLeft = ((shiftLeft % n) + n) % n;
        return s.substring(shiftLeft) + s.substring(0, shiftLeft);
    }
}
