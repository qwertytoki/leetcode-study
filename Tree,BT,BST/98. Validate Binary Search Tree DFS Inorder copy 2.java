
class Solution {
    // inorder 
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    private boolean inorder(TreeNode node){
        if(node == null){
            return true;
        }
        // 左がなくなるまで左に行き続ける
        if(!inorder(node.left)){
            return false;
        }
        // 常に左に行く場合、prevは常に小さくなる
        if(prev != null && prev >= node.val){
            return false;
        }
        prev = node.val;
        // 左にいけなくなった場合、初めて右に行く
        return inorder(node.right);
    }
}