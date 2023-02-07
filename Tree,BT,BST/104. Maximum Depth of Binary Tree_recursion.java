class Solution {
    public int maxDepth(TreeNode root) {
        // solve it by recursion
        // root== null then return
        // Math.max( left, right)
        return dive(root,0);
    }

    private int dive(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        depth++;
        return Math.max(dive(root.left, depth),dive(root.right, depth));
        
    }
}