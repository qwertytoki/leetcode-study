class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer left, Integer right){
        if(root == null){
            return true;
        }
        if(left!= null && left>=root.val){
            return false;
        }
        if(right!= null && root.val >= right){
            return false;
        }
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
}