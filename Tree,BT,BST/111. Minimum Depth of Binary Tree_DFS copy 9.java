
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root,1);
    }

    private int dfs(TreeNode root, int depth){
        if(root.left == null && root.right == null){
            return depth;
        }
        if(root.left == null){
            return dfs(root.right, depth+1);
        }
        if(root.right == null){
            return dfs(root.left, depth+1);
        }
        return Math.min(dfs(root.left,depth+1), dfs(root.right, depth+1));
    }
}