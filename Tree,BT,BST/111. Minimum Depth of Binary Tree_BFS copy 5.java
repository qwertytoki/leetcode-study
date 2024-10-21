
class Solution {
    public int minDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();

            if(node.left == null && node.right == null){
                return depth;
            }
            
            if(node.left!= null){
                queue.add(new Pair(node.left, depth+1));
            }
            if(node.right!= null){
                queue.add(new Pair(node.right, depth+1));
            }
        }
        return Integer.MAX_VALUE;
    }
}