
class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);

        sb.append(String.valueOf(numeratorL / denominatorL));
        long remainder = numeratorL % denominatorL;
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / denominatorL));
            remainder %= denominatorL;
        }
        return sb.toString();
    }
}
