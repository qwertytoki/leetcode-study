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
    boolean isMatched = false;
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        this.targetSum = targetSum;
        pathSum(root, 0);
        return isMatched;
    }

    // returnすると処理が終わってしまうので安易にリターンしないでvoidにしたりStackに入れたりする
    private void pathSum(TreeNode node, int currentSum){
        if(node.left == null && node.right == null){
            if(currentSum + node.val == targetSum){
                isMatched = true;    
            }
            return;
        }
        if(node.left != null ){
            pathSum(node.left, currentSum + node.val);
        }
        if(node.right != null){
            pathSum(node.right, currentSum + node.val);
        }
        
    }
}