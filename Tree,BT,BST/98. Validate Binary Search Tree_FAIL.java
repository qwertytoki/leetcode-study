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
        // 左より親が大きい
        // 右より親が小さい
        // 子も、孫も常に上記の条件を満たす
        if(root == null){
            return true;
        }
        
        if(root.left != null && root.left.val >= root.val)return false;
        if(root.right != null && root.val >= root.right.val)return false;
        
        if(root.left != null){
            isValidBST(root.left);    
        }
        
        if(root.right != null){
            isValidBST(root.right);    
        }
        
        return true;
    }
}