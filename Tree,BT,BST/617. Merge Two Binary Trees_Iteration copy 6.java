/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        Stack<Pair<TreeNode, TreeNode>> stack = new Stack<>();
        stack.add(new Pair(root1, root2));
        while(!stack.isEmpty()){
            Pair<TreeNode,TreeNode> pair = stack.pop();
            TreeNode r1 = pair.getKey();
            TreeNode r2 = pair.getValue();
            if(r2 == null){
                continue;
            }
            r1.val += r2.val;
            if(r1.left == null){
                r1.left = r2.left;
            }else{
                stack.add(new Pair(r1.left,r2.left));
            }
            if(r1.right == null){
                r1.right = r2.right;
            }else{
                stack.add(new Pair(r1.right, r2.right));
            }

        }
        return root1;
    }
}