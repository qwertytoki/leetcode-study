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
    public int minDepth(TreeNode root) {
        // Recursion 
        return dive(root,0);
    }

    private int dive(TreeNode root, int depth ){
        int minDepth = Integer.MAX_VALUE;
        if(root == null){
            return depth;
        }
        if(root.right == null&& root.left == null){
            return depth+1;
        }
        if(root.left != null){
            minDepth = Math.min(dive(root.left,depth+1),minDepth);
        }

        if(root.right != null){
            minDepth = Math.min(dive(root.right,depth+1),minDepth);
        }

        return minDepth;
    }
}