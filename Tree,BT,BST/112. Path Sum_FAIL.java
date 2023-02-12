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
    boolean isMatched = true;
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return pathSum(root, 0);
    }

    private boolean pathSum(TreeNode node, int currentSum){
        if(node == null){
            return currentSum == targetSum;
        }
        if(node.left == null && node.right == null){
            return currentSum == targetSum;
        }
        if(node.left != null ){
            pathSum(node.left, currentSum + node.val);
        }
        if(node.right != null){
            pathSum(node.right, currentSum + node.val);
        }
        return currentSum == targetSum;
    }
}