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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        Stack<Pair<TreeNode, TreeNode>> stack = new Stack<>();
        stack.add(new Pair(root1, root2));
        
        while(!stack.isEmpty()){
            Pair<TreeNode, TreeNode> pair = stack.pop();
            TreeNode n1 = pair.getKey();
            TreeNode n2 = pair.getValue();

            if(n2 == null){
                continue;
            }
            n1.val += n2.val;
            
            if(n1.left == null){
                n1.left = n2.left;
            }else{
                stack.add(new Pair(n1.left, n2.left));
            }
            
            if(n1.right == null){
                n1.right = n2.right;
            }else{
                stack.add(new Pair(n1.right, n2.right));
            }            
        }

        return root1;
    }
}