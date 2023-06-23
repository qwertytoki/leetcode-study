
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair<TreeNode, Integer>(root, targetSum));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.popLast();
            TreeNode node = pair.getKey();
            int currentSum = pair.getValue();
            currentSum -= node.val;
            if(currentSum == 0 && node.left == null && node.right == null){
                return true;
            }
            if(node.left != null){
                stack.add(new Pair<TreeNode, Integer>(node.left, currentSum));
            }
            if(node.right != null){
                stack.add(new Pair<TreeNode, Integer>(node.right, currentSum));
            }
            
        }
        return false;
    }
}