class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0,j=0; j<n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i); //Math.maxにして、現在のiの位置を気にかける
            }
            answer = Math.max(answer, j-i +1);
            map.put(s.charAt(j), j+1);
        }
        return answer;
    }
}