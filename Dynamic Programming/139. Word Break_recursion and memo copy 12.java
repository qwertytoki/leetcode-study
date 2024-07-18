class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return wbHelper(s, new HashSet<>(wordDict), 0);
    }

    private boolean wbHelper(String s, Set<String> wordSet, int start){
        if(start>= s.length()){
            return true;
        }
        if(memo[start]!= null){
            return memo[start];
        }
        for(int i = start; i<=s.length(); i++){
            if(wordSet.contains(s.substring(start,i))&& wbHelper(s, wordSet, i)){
                return memo[start] = true;
            }
        }
        return memo[start] =false;
    }


}