
class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == c) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
