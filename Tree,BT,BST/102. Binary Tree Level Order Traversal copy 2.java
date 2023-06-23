// we need to have the level in somewhere.
// use queue and put them 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            if(result.size() == level){
                result.add(new ArrayList<Integer>());
            }
            result.get(level).add(node.val);
            if(node.left != null){
                queue.add(new Pair<TreeNode, Integer>(node.left,level+1));
            }
            if(node.right != null){
                queue.add(new Pair<TreeNode, Integer>(node.right,level+1));
            }
        }
        return result;
    }
}