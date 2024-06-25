
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        Stack<Pair<TreeNode, TreeNode>> stack = new Stack<>();
        stack.add(new Pair(root1, root2));
        while(!stack.isEmpty()){
            Pair<TreeNode, TreeNode> pair = stack.pop();
            TreeNode node1 = pair.getKey();
            TreeNode node2 = pair.getValue();
            if(node2 == null){
                continue;
            }
            node1.val += node2.val;
            if(node1.left == null){
                node1.left = node2.left;
            }else{
                stack.add(new Pair(node1.left, node2.left));
            }
            if(node1.right == null){
                node1.right = node2.right;
            }else{
                stack.add(new Pair(node1.right, node2.right));
            }
        }
        return root1;
    }
}