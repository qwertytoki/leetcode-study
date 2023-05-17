
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depth = new LinkedList<>();
        stack.add(root);
        depth.add(1);
        int maxDepth = 0;
        while(! stack.isEmpty()){
            root = stack.poll();
            int current = depth.poll();
            maxDepth = Math.max(maxDepth, current);
            if(root.left != null){
                stack.add(root.left);
                depth.add(current+1);
            }
            if(root.right != null){
                stack.add(root.right);
                depth.add(current+1);
            }
            
        }
        return maxDepth;
    }
}

// time : O(N)
// space: O(N)