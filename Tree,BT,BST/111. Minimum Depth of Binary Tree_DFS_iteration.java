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
        //DFS iteration
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if(root == null){
            return 0;
        }
        stack.push(new Pair(root,1));
        int minDepth = Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int currentDepth = current.getValue();
            if(node.left==null && node.right==null){
                minDepth = Math.min(minDepth, currentDepth);
            }
            if(node.left != null){
                stack.push(new Pair(node.left,currentDepth+1));
            }
            if(node.right != null){
                stack.push(new Pair(node.right,currentDepth+1));
            }
        }
        return minDepth;
    }
}