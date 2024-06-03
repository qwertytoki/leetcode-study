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
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.map = new HashMap<>();
        if(root != null){
            helper(root, 0);
        }
        
        return new ArrayList(map.values());
    }

    private void helper(TreeNode root, int level){
        
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        
        if(root.left != null){
            helper(root.left, level+1);
        }
        if(root.right != null){
            helper(root.right, level+1);
        }
    }
}