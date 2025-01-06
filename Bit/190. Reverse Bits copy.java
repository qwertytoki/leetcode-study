
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int power = 31;
        while (n != 0) {
            int i = n & 1;
            result += i << power;
            n = n >>> 1;
            power--;
        }
        return result;
    }
}
