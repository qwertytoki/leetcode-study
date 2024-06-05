
class Solution {
    Integer previous;
    
    public boolean isValidBST(TreeNode root) {
        previous = null;
        return helper(root);
    }
    public boolean helper(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!helper(root.left)){
            return false;
        }
        if(previous != null && previous >= root.val){
            return false;
        }
        previous = root.val;
        return helper(root.right);
    }
}