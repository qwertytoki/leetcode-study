
class Solution {
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        this.prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root){
        if(root == null){
            return true;
        }
        
        if(inorder(root.left) == false){
            return false;
        }
        
        if(prev !=null && prev >= root.val){
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}