class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c)+1);
            }
            max = Math.max(max, i-left+1);
            map.put(c, i);
        }
        return max;
    }
}