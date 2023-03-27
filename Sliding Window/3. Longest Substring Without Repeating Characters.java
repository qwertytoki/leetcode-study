class Solution {
    public int lengthOfLongestSubstring(String s) {
        // left rightを用意して、rightを右にスライドしていく
        // containsMapを用意し、各文字が少なくとも1回しか使われないように調整していく
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, result = 0;

        while(right< s.length()){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r,0)+1);
            while(map.get(r)>1){
                char l = s.charAt(left);
                map.put(l, map.get(l)-1);
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}