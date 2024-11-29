
class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> scharMap = new HashMap<>();
        Map<Character, Character> tcharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if (scharMap.containsKey(schar)) {
                if (tchar != scharMap.get(schar)) {
                    return false;
                }
            } else {
                scharMap.put(schar, tchar);
            }
            if (tcharMap.containsKey(tchar)) {
                if (schar != tcharMap.get(tchar)) {
                    return false;
                }
            } else {
                tcharMap.put(tchar, schar);
            }
        }
        return true;
    }
}
