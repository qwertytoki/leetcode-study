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
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        //各レベルごとに順番に詰めていく。  rootとともに、自身のレベルを保持しておく必要がある
        //一番左から順に格納していく必要
        if(root == null)return levels;
        helper(root, 0);
        return levels;
    }
    
    private void helper(TreeNode node, int level){
        if(levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        
        if(node.left != null){
            helper(node.left, level+1);   
        }
        if(node.right != null){
            helper(node.right, level+1);
        }
    }
    
}