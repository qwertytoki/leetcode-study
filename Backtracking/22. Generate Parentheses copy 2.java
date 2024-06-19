class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(answer, new StringBuilder(), 0, 0, n);
        return answer;
    }
    
    private void backtrack(List<String> answer, StringBuilder curString, 
        int leftCount, int rightCount, int n){
        if(curString.length() == n*2){
            answer.add(curString.toString());
            return;
        }
        if(leftCount<n){
            curString.append("(");
            backtrack(answer, curString, leftCount+1, rightCount, n);
            curString.delete(curString.length()-1,curString.length());
        }
        if(leftCount > rightCount){
            curString.append(")");
            backtrack(answer, curString, leftCount, rightCount+1, n);
            curString.delete(curString.length()-1,curString.length());
        }
    }
}