class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict),0);
    }

    private boolean wordBreakHelper(String s, Set<String> set, int start){
        if(start == s.length()){
            return true;
        }
        for(int end = start +1; end<= s.length();end++){
            if(set.contains(s.substring(start,end)) && wordBreakHelper(s, set, end)){
                return true;
            }
        }
        return false;
    }
}