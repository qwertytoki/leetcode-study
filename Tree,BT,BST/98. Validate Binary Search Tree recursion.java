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
    // すべての親がBSTになってることをチェックする必要はなくて、
    // 一番小さい値もしくは一番大きい値を超えてることだけチェックしてれば良い
    
    
    private boolean validate(TreeNode node, Integer low, Integer high){
        
        if(node == null){
            return true;
        }
        
        if(low!= null && low >= node.val ||  high!= null && node.val>=high ){
            return false;
        }
        return validate(node.left,low,node.val) && validate(node.right, node.val, high);
        
    }
    
    public boolean isValidBST(TreeNode root) {
        return validate(root, null,null);
    }
}