
class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String str : split) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.add(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String str : stack) {
            sb.append(str);
            sb.append("/");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }
}
