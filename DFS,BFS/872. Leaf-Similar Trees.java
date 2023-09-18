
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeafList(root1, list1);
        getLeafList(root2, list2);
        
        return list1.equals(list2);
    }

    public void getLeafList(TreeNode node, List<Integer>list){
        if(node != null){
            if(node.left == null && node.right == null){
                list.add(node.val);
            }
            getLeafList(node.left, list);
            getLeafList(node.right, list);
        }
    }

    // private List<Integer> getLeafList(TreeNode root,List<Integer> list){
    //     if(root.left == null && root.right == null){
    //         list.add(root.val);
    //         return list;
    //     }
    //     if(root.left != null){
    //         return getLeafList(root.left, list);
    //     }else{
    //         return getLeafList(root.right, list);
    //     }
        
    // }
}