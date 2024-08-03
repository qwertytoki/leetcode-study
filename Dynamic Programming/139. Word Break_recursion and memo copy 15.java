class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()+1];
        return wbHelper(s, new HashSet<>(wordDict), 0, memo);
    }

    private boolean wbHelper(String s, Set<String> set, int start, Boolean[] memo ){
        if(start >= s.length()){
            return true;
        }
        if(memo[start]!= null){
            return memo[start];
        }
        
        for(int i =start; i<=s.length();i++){
            if(set.contains(s.substring(start,i))&&wbHelper(s, set, i, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
