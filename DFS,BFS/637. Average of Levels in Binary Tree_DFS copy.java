
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
        List<Double> resultList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();

        calculate(root, 0, resultList, countList);
        for (int i = 0; i < countList.size(); i++) {
            int count = countList.get(i);
            resultList.set(i, resultList.get(i) / count);
        }
        return resultList;
    }

    private void calculate(TreeNode node, int level, List<Double> resultList, List<Integer> countList) {
        if (node == null) {
            return;
        }
        if (resultList.size() == level) {
            resultList.add(0.0);
            countList.add(0);
        }
        resultList.set(level, resultList.get(level) + node.val);;
        countList.set(level, countList.get(level) + 1);

        calculate(node.left, level + 1, resultList, countList);
        calculate(node.right, level + 1, resultList, countList);
    }
}
