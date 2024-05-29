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
        if(root == null)return 0;
        int maxDepth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair(root, 1));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            maxDepth = Math.max(maxDepth, depth);
            if(node.left != null){
                stack.add(new Pair(node.left, depth +1));
            }
            if(node.right != null){
                stack.add(new Pair(node.right, depth +1));
            } 
        }
        return maxDepth;
    }

}