
class Solution {
    TreeNode previous;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(previous != null && previous.val >= root.val){
            return false;
        }
        previous = root;
        return isValidBST(root.right);
    }
}