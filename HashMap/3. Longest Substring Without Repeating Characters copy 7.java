
class Solution {

    public int lengthOfLongestSubstring(String s) {
        // Set? no, we need to have an index when we found the dupli.
        // Map? 
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            max = Math.max(max, i - start + 1);
            map.put(c, i);
        }
        return max;
    }
}
