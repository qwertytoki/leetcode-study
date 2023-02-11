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
        //Recursion
        //0 corner case
        //1 check left and right's availability
        //2 call minDepth with +1

        if(root == null){
            return 0;
        }

        // ここ重要 rootがあるけど次がないときは1を返す
        if(root.left == null&& root.right == null){
            return 1;
        }


        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepth, minDepth(root.left) + 1);
        }
        if(root.right != null){
            minDepth =  Math.min(minDepth, minDepth(root.right) +1);
        }
        
        return minDepth;
        
    }
}