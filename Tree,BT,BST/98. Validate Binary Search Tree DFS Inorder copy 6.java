
class Solution {
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode node){
        if(node == null){
            return true;
        }

        if(!inorder(node.left)){
            return false;
        }
        
        if(prev != null && node.val <= prev){
            return false;
        }
        prev = node.val;
        return inorder(node.right);
    }
}