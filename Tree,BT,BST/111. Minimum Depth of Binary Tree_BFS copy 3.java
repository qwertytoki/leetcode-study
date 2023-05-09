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

//BFS
// Time : O(N) Space : O(N)

class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.add(new Pair(root, 1));
        int current = 0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            current = pair.getValue();
            if(root.left == null && root.right == null){
                break;
            }
            if(root.left != null){
                queue.add(new Pair(root.left, current+1));
            }
            if(root.right != null){
                queue.add(new Pair(root.right, current +1));
            }
        }
        return current;
    }
}