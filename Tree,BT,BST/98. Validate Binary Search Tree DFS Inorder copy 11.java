
class Solution {
    Integer previous;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(previous != null && previous >= root.val){
            return false;
        }
        previous = root.val;
        return isValidBST(root.right);
    }
}