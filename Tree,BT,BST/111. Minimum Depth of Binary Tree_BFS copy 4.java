
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();    
        queue.add(new Pair(root, 1));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            int depth = pair.getValue();
            if(root.left == null && root.right == null){
                return depth;
            }
            if(root.left != null){
                queue.add(new Pair(root.left, depth+1));
            }
            if(root.right != null){
                queue.add(new Pair(root.right, depth+1));
            }
        }
        return Integer.MAX_VALUE;
    }
}

// time: O(N)
// space: O(N)