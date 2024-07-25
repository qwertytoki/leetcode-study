class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int leftIndex = 0;
        int result = 0;
        
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                leftIndex = Math.max(leftIndex, map.get(c));
            }
            result = Math.max(result, i - leftIndex + 1);
            map.put(c, i+1);
        }
        return result;
    }
}