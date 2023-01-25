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
    // いまんところ全然わからんわ
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null){
            return new TreeNode[]{null,null};
        }
        else if(target >= root.val){
            TreeNode[] node = splitBST(root.right,target);
            root.right = node[0];
            node[0] = root;
            return node;
        }else{
            TreeNode[] node = splitBST(root.left,target);
            root.left = node[1];
            node[1] = root;
            return node;
        }
    }
}