class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //Iteration
        //常にroot1を軸に考える、root1だけがnullの場合root2に切り替える
        if(root1 == null) return root2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.add(new TreeNode[]{root1,root2});
        while(!stack.isEmpty()){ 
            TreeNode[] t = stack.pop();
            if(t[1] == null){
                continue;
            }
            t[0].val += t[1].val;
            if(t[0].left == null){
                t[0].left = t[1].left;
            }else{
                stack.push(new TreeNode[]{t[0].left,t[1].left});
            }
            if(t[0].right ==null){
                t[0].right = t[1].right;
            }else{
                stack.push(new TreeNode[]{t[0].right,t[1].right});
            }
            
        }
        return root1;
    }
}