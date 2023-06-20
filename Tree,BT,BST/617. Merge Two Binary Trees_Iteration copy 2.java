
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Stack使いながら左右を足していく。
        // t1に値を寄せていく。 t1がnullならt2をt1に置き換える
        if(t1 == null){
            return t2;
        }
        LinkedList<TreeNode[]> stack = new LinkedList<>();
        stack.add(new TreeNode[]{t1,t2});
        while(!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            if(t[0] == null || t[1] == null){
                continue;
            }
            t[0].val += t[1].val;
            if(t[0].left == null){
                t[0].left = t[1].left;
            }else{
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if(t[0].right == null){
                t[0].right = t[1].right;
            }else{
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
}