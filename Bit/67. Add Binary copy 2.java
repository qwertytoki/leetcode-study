
class Solution {

    public String addBinary(String a, String b) {
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        while (aPointer >= 0 || bPointer >= 0 || counter > 0) {
            int aVal = (aPointer >= 0) ? a.charAt(aPointer) - '0' : 0;
            int bVal = (bPointer >= 0) ? b.charAt(bPointer) - '0' : 0;
            int sum = aVal + bVal + counter;
            counter = sum / 2;
            sum = sum % 2;
            sb.append(sum);
            aPointer--;
            bPointer--;
        }
        return sb.reverse().toString();
    }
}
