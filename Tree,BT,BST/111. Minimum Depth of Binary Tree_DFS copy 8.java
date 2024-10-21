
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root, 0);    
    }

    private int dfs(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        if(root.left == null){
            return dfs(root.right,depth+1);
        }
        if(root.right == null){
            return dfs(root.left, depth+1);
        }
        return Math.min(dfs(root.left, depth+1), dfs(root.right, depth+1));
    }
    
}