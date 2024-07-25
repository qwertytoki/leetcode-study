class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0,0,n,new StringBuffer(), result);
        return result;
    }

    private void backtrack(int left, int right, int size, StringBuffer sb, List<String> result){
        if(sb.length() == size*2){
            result.add(sb.toString());
            return;
        }
        if(left<size){
            sb.append("(");
            backtrack(left+1, right, size, sb, result);
            sb.delete(sb.length()-1, sb.length());
        }
        if(left>right){
            sb.append(")");
            backtrack(left, right+1, size, sb, result);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}