
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
        List<Double> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        calculate(root, 0, count, result);

        for (int i = 0; i < count.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;

    }

    private void calculate(TreeNode node, int level, List<Integer> count, List<Double> sum) {
        if (node == null) {
            return;
        }
        if (count.size() == level) {
            count.add(0);
        }
        int co = count.get(level);
        count.set(level, co + 1);
        if (sum.size() == level) {
            sum.add(0.0);
        }
        sum.set(level, sum.get(level) + node.val);
        calculate(node.left, level + 1, count, sum);
        calculate(node.right, level + 1, count, sum);
    }
}
