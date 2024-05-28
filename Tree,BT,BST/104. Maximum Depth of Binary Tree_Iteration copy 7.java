
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        int result = 0;
        stack.add(new Pair(root, 1));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currDepth = pair.getValue();
            result = Math.max(currDepth, result);
            if(node.left != null){
                stack.add(new Pair(node.left, currDepth+1));
            }
            if(node.right != null){
                stack.add(new Pair(node.right, currDepth+1));
            }
        }
        return result;
    }
}