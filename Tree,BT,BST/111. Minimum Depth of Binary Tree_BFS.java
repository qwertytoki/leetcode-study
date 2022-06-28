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
        if(root == null){
            return 0;
        }
        // Integer is the current depth in the treeNode.
        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair(root,1));
        int minValue = 0;
        
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair= queue.poll();
            root = pair.getKey();
            minValue = pair.getValue();
            if(root.left == null && root.right == null){
                break;
            }
            if(root.left != null){
                queue.add(new Pair(root.left,minValue+1));
            }
            
            if(root.right != null){
                queue.add(new Pair(root.right,minValue+1));
            }
        }
        return minValue;
    }

    
//     public int minDepthDFS(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         if(root.left == null && root.right == null){
//             return 1;
//         }
        
//         int minDepth = Integer.MAX_VALUE;
//         if(root.left != null){
//             minDepth = Math.min(minDepth,minDepth(root.left));
//         }
        
//         if(root.right != null){
//             minDepth = Math.min(minDepth,minDepth(root.right));
//         }
//         return minDepth +1;        
//     }
}