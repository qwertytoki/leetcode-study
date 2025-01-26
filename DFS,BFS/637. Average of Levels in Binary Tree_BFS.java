
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

    public List<Double> averageOfLevels(TreeNode root) {
        //BFS 
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            double sum = 0.0;
            int count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                count++;
                if (node.left != null) {
                    temp.add(node.left);

                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            result.add(sum / count);
        }
        return result;
    }
}
