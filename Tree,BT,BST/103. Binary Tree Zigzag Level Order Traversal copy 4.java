
class Solution {
    List<List<Integer>> nodeList;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        nodeList = new ArrayList<>();
        if(root == null){
            return nodeList;
        }
        
        helper(root, 0);
        return nodeList;
    }
    private void helper(TreeNode root, int level){
        if(nodeList.size()== level){
            nodeList.add(new ArrayList<>());
        }
        if(level%2 == 0){
            nodeList.get(level).add(root.val);
        }else{
            nodeList.get(level).add(0,root.val);
        }
        if(root.left != null){
            helper(root.left, level+1);
        }
        if(root.right != null){
            helper(root.right, level+1);
        }
        
    }
}