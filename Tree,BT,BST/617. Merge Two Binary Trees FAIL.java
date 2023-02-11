
class Solution {
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //DFS
        //3 cases 
        //i   root1 is null 
        //ii  root2 is null 
        //iii both are null
        //iv  both are not null 

        TreeNode result = new TreeNode();
        merge(result,root1,root2);
        return result;
    }

    private void merge(TreeNode result, TreeNode root1, TreeNode root2){
        
        if(root1 == null && root2 == null){
            return ;
        }else if(root1 == null){
            result.val = root2.val;
            merge(result.left,null,root2.left);
            merge(result.right,null,root2.right);
        }else if(root2 == null){
            result.val = root1.val;
            merge(result.left,root1.left,null);
            merge(result.right,root1.right,null);
        }else{
            result.val = root1.val + root2.val;
            merge(result.left,root1.left,root2.left);
            merge(result.right,root1.right,root2.right);
        }
    }
}