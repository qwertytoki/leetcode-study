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
    LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        stack.add(new Pair(root, 1));
        
        int minDepth = Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pollLast();
            root = pair.getKey();
            int current = pair.getValue();
            if(root.left== null && root.right == null){
                minDepth = Math.min(minDepth, current);
            }
            if(root.left != null){
                stack.add(new Pair(root.left, current+1));
            }
            if(root.right != null){
                stack.add(new Pair(root.right, current+1));
            }
        }
        return minDepth;
    }
}