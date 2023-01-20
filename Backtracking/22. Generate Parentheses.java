class Solution {
    //これはデバックしてみるとよく分かる。
    //非常に良くできていて、美しい
    public List<String> generateParenthesis(int n) {
        // backtracking
        List<String> result = new ArrayList<>();
        backtracking(result, new StringBuilder(), 0,0,n);
        return result;
    }

    private void backtracking(List<String>result, StringBuilder current, int open,int close, int max){
        if(current.length() == max * 2){
            result.add(current.toString());
            return;
        }
        if(open<max){
            current.append("(");
            backtracking(result,current,open+1,close,max);
            current.deleteCharAt(current.length()-1);
        }
        if(close<open){
            current.append(")");
            backtracking(result,current,open,close+1,max);
            current.deleteCharAt(current.length()-1);
        }
    }
}