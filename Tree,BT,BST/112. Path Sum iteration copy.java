
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
            
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root,targetSum));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair= queue.poll();
            TreeNode node = pair.getKey();
            int remain = pair.getValue();
            remain -= node.val;
            if(node.left ==null && node.right == null){
                if(remain == 0){
                    return true;
                }
                continue;
            }
            if(node.left != null){
                queue.add(new Pair(node.left, remain));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, remain));
            }
        }
        return false;
    }
    
}