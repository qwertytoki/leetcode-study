
class Solution {
   // FAIL 
    //常に右が親より大きいこと
    //常に左が親より小さいこと
    //このチェックを下まで繰り返すこと
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        validate(root);
        return isValid;
    }
    
    private void validate(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null && node.left.val >= node.val){
            isValid = false;
            return;
        }
        if(node.right != null && node.val >= node.right.val){
            isValid = false;
            return;
        }
        validate(node.left);
        validate(node.right);        
    }
}