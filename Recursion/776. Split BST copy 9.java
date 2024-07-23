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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root== null){
            return new TreeNode[]{null, null};
        }
        if(root.val<= target){
            TreeNode[] nodes = splitBST(root.right, target);
            root.right= nodes[0];
            nodes[0] = root;
            return nodes;
        }else{
            TreeNode[] nodes = splitBST(root.left, target);
            root.left = nodes[1];
            nodes[1] = root;
            return nodes;
        }
    }
}