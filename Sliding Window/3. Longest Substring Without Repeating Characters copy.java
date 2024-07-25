class Solution {
    int[] alphabets;
    public int lengthOfLongestSubstring(String s) {
      // 普通にMap使ってゴリ押しすればいけそう
      Map<Character, Integer> charCountMap = new HashMap<>();
      int start = 0;
      int end = 0;
      char[] charArray = s.toCharArray();
      int result = 0;
      while(end < s.length()){
        char c = charArray[end];
        charCountMap.put(c, charCountMap.getOrDefault(c,0)+1);
      
        while(charCountMap.get(c) > 1){
          char l = charArray[start];
          charCountMap.put(l,charCountMap.get(l) -1);
          start++;
        }
      
        result = Math.max(result, end-start+1);
        end++;
      }
      return result;
    }

    
}