
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> zigList = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(! queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            if(zigList.size()==depth){
                zigList.add(new ArrayList<>());
            }
            List<Integer> list = zigList.get(depth);
            if(depth %2 == 0){
                list.add(node.val);
            }else{
                list.add(0, node.val);
            }
            if(node.left != null){
                queue.add(new Pair(node.left, depth+1));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, depth+1));
            }
        }
        return zigList;
        
    }
}