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
    int targetSum;
    boolean result = false;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        this.targetSum = targetSum;
        addValue(root,0);
        return result;
    }
    
    private void addValue(TreeNode node, int currentSum){
        if(node.left == null && node.right == null){
            if(currentSum+node.val == targetSum){
                result = true;
            }
            return;
        }
        if(node.left != null){
            addValue(node.left, currentSum+node.val);    
        }
        if(node.right != null){
            addValue(node.right, currentSum+node.val);    
        }
        
    }
}