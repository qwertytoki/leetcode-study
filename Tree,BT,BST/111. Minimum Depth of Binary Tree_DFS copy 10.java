
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if(root.left != null){
            depth = Math.min(depth, minDepth(root.left)+1);
        }
        if(root.right != null){
            depth = Math.min(depth, minDepth(root.right)+1);
        }
        return depth;
    }
}