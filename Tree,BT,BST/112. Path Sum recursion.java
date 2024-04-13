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
    boolean isDetected;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        this.isDetected= false;
        helper(root, targetSum);

        return isDetected;
    }

    private void helper(TreeNode root, int targetSum){
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            isDetected = true;
            return;
        }
        if(root.left != null){
            helper(root.left, targetSum);
        }
        if(root.right != null){
            helper(root.right, targetSum);
        }
    }

    
}