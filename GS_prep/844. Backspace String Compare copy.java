
class Solution {

    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cArray = s.toCharArray();
        for (char c : cArray) {
            if (c != '#') {
                stack.add(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack.toString();
    }
}
