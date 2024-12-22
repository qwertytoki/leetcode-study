
class Solution {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (fast != 1) {
            slow = calc(slow);
            fast = calc(calc(fast));
            if (fast == slow) {
                break;
            }
        }
        return fast == 1;
    }

    private int calc(int n) {
        int result = 0;
        while (n != 0) {
            int i = n % 10;
            result += i * i;
            n = n / 10;
        }
        return result;
    }
}
