
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(new ArrayList<>());
        addToList(root, 0);
        return result;
    }

    private void addToList(TreeNode root, int level){
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left != null){
            addToList(root.left, level+1);
        }
        if(root.right != null){
            addToList(root.right, level+1);
        }
    }
}