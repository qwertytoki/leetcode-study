
class Solution {
    public TreeNode mergeTrees(TreeNode r1, TreeNode r2) {
        if(r1 == null){
            return r2;
        }
        
        LinkedList<TreeNode[]> stack = new LinkedList<>();
        stack.add(new TreeNode[]{r1,r2});
        while(!stack.isEmpty()){
            TreeNode[] nodes = stack.pop();
            TreeNode root1 = nodes[0];
            TreeNode root2 = nodes[1];
            if(root1 == null || root2 == null){
                continue;
            }
            root1.val += root2.val;
            
            if(root1.left == null){
                root1.left = root2.left;
            }else{
                stack.add(new TreeNode[]{root1.left, root2.left});
            }
            if(root1.right == null){
                root1.right = root2.right;
            }else{
                stack.add(new TreeNode[]{root1.right, root2.right});
            }
        }

        return r1;
    }
}