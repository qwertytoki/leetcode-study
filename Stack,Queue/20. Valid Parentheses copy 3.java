class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c=='{' || c == '['){
                stack.add(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char pop = stack.pollLast();
            if(
                (pop == '(' && c == ')') || 
                (pop == '{' && c == '}') || 
                (pop == '[' && c == ']') 
            ){
                continue;
            }else{
                return false;
            }
        }
        return stack.size() == 0;
    }
}