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
    public int maxDepth(TreeNode root) {
        //DFS 
        int max = 0;
        if(root == null){
            return max;
        }else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return  Math.max(left_height, right_height) + 1; 
        }
    }
}