// even : put as asc
// odd  : put as desc
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(new ArrayList<>());
        putZigZag(root, 0);
        return result;
    }

    private void putZigZag(TreeNode node, int level){
         if(result.size() == level){
             result.add(new ArrayList<>());
         }
         
         if(level % 2 == 0){
             result.get(level).add(node.val);
         }else{
             result.get(level).add(0,node.val);
         }
         if(node.left != null){
             putZigZag(node.left, level+1);
         }
         if(node.right != null){
             putZigZag(node.right, level+1);
         }
    }
}