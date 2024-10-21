
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }           
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode node, Integer left, Integer right){
        if(node == null){
            return true;
        }
        
        if(left != null && node.val <= left){
            return false;
        }
        if(right != null && node.val >= right){
            return false;
        }

        return validate(node.left, left, node.val) && validate(node.right, node.val, right);
    }
}