class Solution {
    /**
        0 edge case 
        1 call recursion
        recursion method
            2 if exit case
            3 generate new list item in levels if not exist
            4 put to the list, consider even or odd
            5 call recursion with leftand right
        6 return list
     */
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //0
        if(root == null) return levels;
        //1
        traverse(root, 0);
        //6
        return levels;
    }

    private void traverse(TreeNode root, int level){
        //2
        if(root == null){
            return;
        }
        //3
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        List<Integer> levelList = levels.get(level);
        //4 
        if(level%2 == 0){
            levelList.add(root.val);
        }else{
            levelList.add(0, root.val);
        }
        //5
        traverse(root.left,level+1);
        traverse(root.right,level+1);
        
    }

}