
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        analyseLeaf(list1, root1);
        analyseLeaf(list2, root2);

        return list1.equals(list2);
        
    }

    private void analyseLeaf(List<Integer> list, TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                list.add(root.val);
                return;
            }
            analyseLeaf(list, root.left);
            analyseLeaf(list, root.right);
        }
        
    }
}