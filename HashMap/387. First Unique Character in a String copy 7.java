
class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] cArray = s.toCharArray();

        for (char c : cArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
