
class Solution {

    private static final String[] romanArray = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] intArray = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length && num > 0; i++) {
            while (num >= intArray[i]) {
                num -= intArray[i];
                sb.append(romanArray[i]);
            }
        }
        return sb.toString();
    }
}
