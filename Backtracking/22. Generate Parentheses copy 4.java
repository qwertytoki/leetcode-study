class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), result);
        return result; 
    }

    private void backtrack(int left, int right, int target, StringBuilder sb, List<String> result){
        if(sb.length() == target*2){
            result.add(sb.toString());
            return;
        }
        if(left<target){
            sb.append("(");
            backtrack(left+1, right, target, sb, result);
            sb.delete(sb.length()-1, sb.length());
        }
        if(left>right){
            sb.append(")");
            backtrack(left, right+1, target, sb, result);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}