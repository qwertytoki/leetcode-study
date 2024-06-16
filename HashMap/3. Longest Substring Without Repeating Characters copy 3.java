class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int i =0;
        for(int j=0; j<s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i= Math.max(i, map.get(s.charAt(j)));
            }
            result = Math.max(result, j-i +1);
            map.put(s.charAt(j), j+1);
        }
        return result;
    }
}