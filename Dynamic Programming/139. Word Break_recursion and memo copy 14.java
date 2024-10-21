class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()+1];
        return wbHelper(s, new HashSet<>(wordDict), 0, memo);
    }

    private boolean wbHelper(String s, HashSet<String> set, int start, Boolean[]memo){
        int n = s.length();
        if(start>= n){
            return true;
        }
        if(memo[start]!= null){
            return memo[start];
        }
        for(int i =start; i<=n; i++){
            if(set.contains(s.substring(start,i))&& wbHelper(s, set, i,memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
        
    }
}