class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, new StringBuffer(), result);
        return result;
    }

    private void backtrack(int left, int right, int size, StringBuffer current, List<String> result){
        if(current.length() == 2 * size){
            result.add(current.toString());
            return;   
        }
        if(left<size){
            current.append("(");
            backtrack(left+1, right, size, current, result);
            current.delete(current.length()-1, current.length());
        }
        if(left>right){
            current.append(")");
            backtrack(left, right+1, size, current, result);
            current.delete(current.length()-1, current.length());
        }
    }
}