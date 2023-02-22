class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        traverse(0,root);
        return levels;
    }

    //ここで階層引数にもたせるよう考えることが肝要
    private void traverse(int level, TreeNode node){
        if(node == null){
            return;
        }
        if(levels.size()==level){
            levels.add(new ArrayList<>());
        }
        List<Integer> levelList = levels.get(level);
        levelList.add(node.val);

        traverse(level+1,node.left);
        traverse(level+1,node.right);
    }
}