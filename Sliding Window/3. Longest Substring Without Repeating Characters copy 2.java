class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 0;
        while(end<s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.get(c)>1){
                char d = s.charAt(start);
                map.put(d, map.get(d)-1);
                start++;
            }
            result = Math.max(result, end - start +1);
            end++;
        }
        return result;
    }
}