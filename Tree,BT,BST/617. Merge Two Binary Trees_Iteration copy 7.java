
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair(root1,root2));
        while(! queue.isEmpty()){
            Pair<TreeNode, TreeNode> pair = queue.poll();
            TreeNode r1 = pair.getKey();
            TreeNode r2 = pair.getValue();
            if(r1 ==null || r2 == null){
                continue;
            }
            r1.val+= r2.val;
            if(r1.left == null){
                r1.left = r2.left;
            }else{
                queue.add(new Pair(r1.left, r2.left));
            }

            if(r1.right == null){
                r1.right = r2.right;
            }else{
                queue.add(new Pair(r1.right, r2.right));
            }
        }

        return root1;
    }
}