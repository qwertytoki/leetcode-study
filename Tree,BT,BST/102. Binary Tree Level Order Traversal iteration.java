// stackでやると、各リストの順番が逆になってしまう
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode,Integer>(root,0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();
            if(result.size() == level){
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            if(node.left != null){
                queue.add(new Pair<TreeNode,Integer>(node.left, level+1));
            }
            if(node.right != null){
                queue.add(new Pair<TreeNode,Integer>(node.right, level+1));
            }
        }
        return result;
    }
}

