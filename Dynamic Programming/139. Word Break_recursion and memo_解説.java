class Solution {
    // memo + recursion
    // どこかの文字までがwordDictに引っかかることを確認し、後続は再帰でさらに確認する
    // setに単語がある → 残りの文字でwbHelper()呼び出し→setに単語がある→残りの文字で...
    // を繰り返し、ターゲットの最後の文字までこれたなら、trueを返す。 これなかったらfalse

    //null許容させたいからBooleanにする
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return wbHelper(s, new HashSet(wordDict), 0);
    }

    private boolean wbHelper(String s, HashSet<String>set, int start){
        if(s.length()<= start){
            //最後の文字までこれたならtrue
            return true;
        }
        if(memo[start]!= null){
            return memo[start];
        }
        //substringを使うので、s.length()の最後の文字まで繰り返してあげる
        for(int i = start; i<=s.length(); i++){
            if(set.contains(s.substring(start,i))&& wbHelper(s,set,i)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}