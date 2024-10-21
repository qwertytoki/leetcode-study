class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(), result);
        return result;
    }

    private void backtrack(int leftCount, int rightCount, int n, StringBuilder current, List<String> result){
        if(current.length() == 2*n){
            result.add(current.toString());
            return;
        }
        if(leftCount<n){
            current.append("(");
            backtrack(leftCount+1, rightCount, n, current,result);
            current.delete(current.length()-1, current.length());
        }
        if(leftCount>rightCount){
            current.append(")");
            backtrack(leftCount, rightCount+1, n, current, result);
            current.delete(current.length()-1, current.length());
        }
    }
}