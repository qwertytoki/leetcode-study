class Solution {
    public int maxDepth(TreeNode root) {
        // if(root == null){
        //     return 0;
        // }
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // return Math.max(left,right)+1;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        int maxDepth = 0;
        stack.add(root);
        depths.add(1);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            int depth = depths.poll();
            if(node == null){
                continue;
            }
            maxDepth = Math.max(maxDepth, depth);
            stack.add(node.left);
            stack.add(node.right);
            depths.add(depth+1);
            depths.add(depth+1);
        }
        return maxDepth;
         
    }
}