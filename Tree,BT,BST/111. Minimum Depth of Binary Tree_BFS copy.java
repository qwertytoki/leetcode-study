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
        //BFS
        //0 edge case
        //1 prepare Queue and etc.
        //2 while queue is not empty
        //3 if both TreeNode.right and left are null, compare minDepth
        //4 if TreeNode.left is not null then add to queue
        //5 if TreeNode.right is not null then add to queue
        //6 return minDepth

        //0
        if(root == null){
            return 0;
        }
        //1
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root,1));
        int minDepth = Integer.MAX_VALUE;
        //2
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> currentPair = queue.remove();
            TreeNode node = currentPair.getKey();
            int currentDepth = currentPair.getValue();
            //3
            if(node.left == null&&node.right == null){
                minDepth = Math.min(minDepth,currentDepth);
            }
            //4
            if(node.left != null){
                queue.add(new Pair(node.left,currentDepth+1));
            }
            //5
            if(node.right != null){
                queue.add(new Pair(node.right,currentDepth+1));
            }
            
        }
        //6
        return minDepth;
    }
}