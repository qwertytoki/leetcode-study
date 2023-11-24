class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int left, int right, int max){
        if(current.length() >= max*2){
            result.add(current.toString());
            return;
        }
        if(left < max){
            current.append("(");
            backtrack(result, current, left+1, right, max);
            current.deleteCharAt(current.length()-1);
        }
        if(left > right){
            current.append(")");
            backtrack(result, current, left, right+1, max);
            current.deleteCharAt(current.length()-1);
        }

    }
}