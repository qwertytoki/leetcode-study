
class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int i = n & 1;
            if (i == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
