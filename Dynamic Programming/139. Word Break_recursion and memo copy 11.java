class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return wbHelper(s, new HashSet<>(wordDict), 0);
    }

    private boolean wbHelper(String s, Set<String> set, int index){
        if(s.length()<= index){
            return true;
        }
        if(memo[index] != null){
            return memo[index];
        }
        
        for(int i = index; i<= s.length(); i++){
            if(set.contains(s.substring(index,i)) && wbHelper(s, set, i)){
                return memo[index] = true;
            }
        }

        return memo[index] = false;

    }
}