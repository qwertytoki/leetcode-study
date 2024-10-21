class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return wbHelper(s, new HashSet(wordDict), 0);
    }

    private boolean wbHelper(String s, Set<String> set, int start){
        if(s.length() <= start){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        for(int i = start; i<= s.length(); i++){
            if(set.contains(s.substring(start, i)) && wbHelper(s, set, i)){
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}