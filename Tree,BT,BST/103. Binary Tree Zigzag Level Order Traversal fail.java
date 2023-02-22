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

 //これは間違っている
class Solution {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if( root == null)return levels;
        traverse(0,root);
        return levels;
    }

    private void traverse(int level, TreeNode node){
        if(node == null){
            return;
        }
        
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        List<Integer> list = levels.get(level);
        list.add(node.val);

        //Call時に順番を逆にしてもだめ。結果追加時に順番を逆にしないといけない
        if(level % 2 == 1){
            traverse(level+1, node.left);
            traverse(level+1, node.right);
        }else{
            traverse(level+1, node.right);
            traverse(level+1, node.left);
        }
    }
}