
class Solution {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> cMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        int count = pattern.length();
        String[] sArr = s.split(" ");
        int sCount = sArr.length;
        if (count != sCount) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            char c = pattern.charAt(i);
            String sPart = sArr[i];
            if (!cMap.containsKey(c) && !sMap.containsKey(sPart)) {
                cMap.put(c, sPart);
                sMap.put(sPart, c);
            } else if (!cMap.getOrDefault(c, sPart).equals(sPart)
                    || !sMap.getOrDefault(sPart, c).equals(c)) {
                return false;
            }
        }
        return true;
    }
}
