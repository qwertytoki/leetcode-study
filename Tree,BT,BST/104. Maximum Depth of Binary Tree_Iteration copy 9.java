
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));
        int max = 0;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            max = Math.max(max, depth);
            if(node.left != null){
                stack.add(new Pair<>(node.left, depth+1));
            }
            if(node.right != null){
                stack.add(new Pair<>(node.right, depth+1));
            }
        }

        return max;
    }
}