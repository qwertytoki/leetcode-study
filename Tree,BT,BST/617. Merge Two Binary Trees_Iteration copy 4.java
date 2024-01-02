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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        LinkedList<TreeNode[]> stack = new LinkedList<>();
        stack.add(new TreeNode[]{t1,t2});
        while(!stack.isEmpty()){
            TreeNode[] nodes = stack.pop();
            TreeNode root1 = nodes[0];
            TreeNode root2 = nodes[1];
            if(root1 == null || root2 == null){
                continue;
            }
            root1.val += root2.val;
            if(root1.left == null){
                root1.left = root2.left;
            }else{
                stack.add(new TreeNode[]{root1.left,root2.left});
            }

            if(root1.right == null){
                root1.right = root2.right;
            }else{
                stack.add(new TreeNode[]{root1.right, root2.right});
            }
        }
        return t1;
    }
}