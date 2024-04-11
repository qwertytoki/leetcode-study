
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root,1);
    }

    private int helper(TreeNode root, int depth){
        if(root == null){
            return depth-1;
        }
        return Math.max(helper(root.left, depth+1),helper(root.right, depth+1));
    }
}