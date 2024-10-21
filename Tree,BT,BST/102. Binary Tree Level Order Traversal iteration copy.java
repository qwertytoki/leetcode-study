
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair(root, 0));
        
        while(! queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            if(node == null) continue;
            int depth = pair.getValue();
            if(result.size()== depth){
                result.add(new ArrayList<>());
            }
            List<Integer> list = result.get(depth);
            list.add(node.val);
            if(node.left != null){
                queue.add(new Pair(node.left, depth+1));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, depth+1));
            }
        }
        return result;
    }
}