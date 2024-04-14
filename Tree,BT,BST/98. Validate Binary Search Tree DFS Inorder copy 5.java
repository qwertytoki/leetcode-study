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
    public boolean isValidBST(TreeNode root) {
        return inorder(root, null);
    }

    private boolean inorder(TreeNode root, Integer prev){
        if(root == null){
            return true;
        }

        if(!inorder(root.left, prev)){
            return false;
        }
        
        if(prev != null && prev >= root.val){
            return false;
        }

        return inorder(root.right, root.val);

    }
}