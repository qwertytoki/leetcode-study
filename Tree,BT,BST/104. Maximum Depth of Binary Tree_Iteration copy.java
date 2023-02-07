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
        // solve by iteration
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.add(root);
        depths.add(1);
        int maxDepth = 0;
        int currentDepth = 0;
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            currentDepth = depths.pop();
            if(currentNode != null){
                maxDepth = Math.max(maxDepth, currentDepth);
                stack.push(currentNode.left);
                stack.push(currentNode.right);
                depths.push(currentDepth+1);
                depths.push(currentDepth+1);
            }
        }
        return maxDepth;
    }
}