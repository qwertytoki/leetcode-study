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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair(root, 0));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currentSum = pair.getValue();
            
            currentSum += node.val;
            if(node.left==null && node.right == null && currentSum == targetSum){
                return true;
            }            
            if(node.left!= null){
                stack.add(new Pair(node.left, currentSum));

            }
            if(node.right != null){
                stack.add(new Pair(node.right, currentSum));
            }
        }
        return false;
    }
}