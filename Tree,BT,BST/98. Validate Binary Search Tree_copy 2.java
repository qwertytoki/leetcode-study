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
        //右子は常に親を上回る
        //左子は常に親を下回る
        //最初に右に行った場合、下値は常に始点を上回る
        //最初に左に行った場合、上値は常に始点を下回る
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer low, Integer high){
        if(root == null){
            return true;
        }
        if(high != null && root.val >= high){
            return false;
        }
        if(low != null && root.val <= low){
            return false;
        }
        return validate(root.left,low, root.val) && validate(root.right, root.val, high);
    }
}