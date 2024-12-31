
class Solution {

    public String addBinary(String a, String b) {
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (aPointer > -1 || bPointer > -1) {
            int aNum = aPointer >= 0 ? a.charAt(aPointer) - '0' : 0;
            int bNum = bPointer >= 0 ? b.charAt(bPointer) - '0' : 0;
            int current = aNum + bNum + carry;
            carry = current / 2;
            sb.append(current % 2);
            aPointer--;
            bPointer--;
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();

    }
}
