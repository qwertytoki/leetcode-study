class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length; i++){
            Set<String> set = new HashSet<>();
            boolean isRepeat = false;
            int j = i;
            while(!isRepeat){
                if(j >=chars.length){
                    longest = Math.max(longest,set.size());
                    break;
                }
                String charStr = Character.toString(chars[j]);
                if(!set.contains(charStr)){
                    set.add(charStr);
                    j++;
                }else{
                    isRepeat = true;
                    longest = Math.max(longest,set.size());
                }
            }
        }
        return longest;      
    }
}