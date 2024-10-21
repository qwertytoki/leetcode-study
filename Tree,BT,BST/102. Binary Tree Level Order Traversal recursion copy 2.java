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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(result.size()==depth){
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(depth);
        list.add(root.val);
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}