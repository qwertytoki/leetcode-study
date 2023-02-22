
class Solution {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if( root == null)return levels;
        traverse(0,root);
        return levels;
    }

    private void traverse(int level, TreeNode node){
        if(node == null){
            return;
        }
        
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        List<Integer> list = levels.get(level);

        // mod2が0なら右に詰める、1なら左に詰める
        if(level % 2 == 0){
            list.add(node.val);
        }else{
            list.add(0,node.val);
        }
        
        traverse(level +1, node.left);
        traverse(level +1, node.right);
    }
}