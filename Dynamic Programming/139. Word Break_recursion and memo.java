class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict),0, new Boolean[s.length()]);
    }

    private boolean wordBreakHelper(String s, Set<String> set, int start, Boolean[] memo){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }

        for(int end = start +1; end<= s.length();end++){
            if(set.contains(s.substring(start,end)) && wordBreakHelper(s, set, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}