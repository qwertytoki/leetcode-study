
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || val == root.val){
            return root;
        }
        if(root.val < val){
            return searchBST(root.right, val);
        }else{
            return searchBST(root.left, val);
        }
        
    }
}