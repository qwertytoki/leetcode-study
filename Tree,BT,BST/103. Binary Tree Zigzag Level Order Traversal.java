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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // levelが偶数なら左から、奇数なら右から数えるようにする
        // 基本的なやり方は102と同じ
        if(root == null){
            return result;
        }
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode node, int level){
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
            result.get(level).add(node.val);
        }else{
            if(level %2 == 0){
                result.get(level).add(node.val);
            }else{
                result.get(level).add(0,node.val);
            }
        }
        if(node.left != null){
            helper(node.left,level+1);
        }
        if(node.right != null){
            helper(node.right, level+1);
        }
    }
}