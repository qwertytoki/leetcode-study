
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        List<List<Integer>> result = new ArrayList<>();
        
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            
            if(result.size() == level){
                result.add(new ArrayList());
            }
            if(level%2 == 0){
                result.get(level).add(node.val);
            }else{
                result.get(level).add(0, node.val);
            }
            if(node.left != null){
                queue.add(new Pair(node.left, level+1));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, level+1));
            }
        }
        return result;
    }
}