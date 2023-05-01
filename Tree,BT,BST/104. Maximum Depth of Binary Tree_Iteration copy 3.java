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
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();

        int maxDepth = 0;
        int currentDepth = 0;
        nodes.add(root);
        depths.add(1);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            currentDepth = depths.poll();

            if(node == null){
                continue;
            }
            maxDepth = Math.max(currentDepth, maxDepth);
            nodes.add(node.left);
            nodes.add(node.right);
            depths.add(currentDepth+1);
            depths.add(currentDepth+1);
        }

        return maxDepth;
    }
}