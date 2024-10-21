
class Solution {

    public boolean isPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb1.append(Character.toLowerCase(c));
            }
        }
        s = sb1.toString();
        int mid = s.length() / 2;
        int leftMid = 0;
        int rightMid = 0;
        if (s.length() % 2 == 1) {
            leftMid = mid - 1;
            rightMid = mid + 1;
        } else {
            leftMid = mid - 1;
            rightMid = mid;
        }
        sb1 = new StringBuilder();
        for (int i = 0; i <= leftMid; i++) {
            sb1.append(s.charAt(i));
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = s.length() - 1; i >= rightMid; i--) {
            sb2.append(s.charAt(i));
        }
        return sb1.toString().equals(sb2.toString());
    }
}
