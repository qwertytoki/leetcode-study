
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int level = 0;
        traverse(result, level, root);
        return result;
    }

    private void traverse(List<List<Integer>> result, int level, TreeNode node){
        if(node == null){
            return;
        }
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        traverse(result, level + 1, node.left);
        traverse(result, level + 1, node.right);
    }
}