
class Solution {

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (fast != 1) {
            fast = nextNumber(nextNumber(fast));
            slow = nextNumber(slow);
            if (fast == slow) {
                break;
            }
        }
        return fast == 1;
    }

    private int nextNumber(int n) {
        int totalNumber = 0;
        while (n > 0) {
            int a = n % 10;
            totalNumber += a * a;
            n = n / 10;
        }
        return totalNumber;
    }
}
