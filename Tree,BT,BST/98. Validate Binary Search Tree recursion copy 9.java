class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(null, null, root);
    }

    private boolean helper(Integer left, Integer right, TreeNode node){
        if(left != null){
            if(left>=node.val){
                return false;
            }
        }
        if(right != null){
            if(node.val>=right){
                return false;
            }
        }
        boolean leftResult = true;
        if(node.left != null){
            leftResult = helper(left, node.val, node.left);    
        }
        boolean rightResult = true;
        if(node.right != null){
            rightResult = helper(node.val, right, node.right);
        }
        return leftResult && rightResult;
    }
}