class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        // recursion + memo 
        memo = new Boolean[s.length()+1];
        return wordBreakHelper(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakHelper(String s, Set<String> wordSet,  int start){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        
        for(int end = start +1; end<= s.length(); end++){
            if(wordSet.contains(s.substring(start,end)) && wordBreakHelper(s,wordSet,end)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;

    }
}