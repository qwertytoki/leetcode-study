
class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> scharMap = new HashMap<>();
        Map<Character, Character> tcharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if (!scharMap.containsKey(schar) && !tcharMap.containsKey(tchar)) {
                scharMap.put(schar, tchar);
                tcharMap.put(tchar, schar);
            } else if (!scharMap.getOrDefault(schar, tchar).equals(tchar)
                    || !tcharMap.getOrDefault(tchar, schar).equals(schar)) {
                return false;
            }
        }
        return true;
    }
}
