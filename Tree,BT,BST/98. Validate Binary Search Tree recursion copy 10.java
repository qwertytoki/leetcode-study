
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode node, Integer left, Integer right){
        if(node == null){
            return true;
        }
        if(left != null && left >= node.val){
            return false;
        }
        if(right != null && node.val >= right){
            return false;
        }
        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}