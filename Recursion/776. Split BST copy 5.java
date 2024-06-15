
class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null){
            return new TreeNode[]{null, null};
        }
        if(target <root.val){ //target==valだったら含める必要がある
            TreeNode[] nodes = splitBST(root.left, target);
            root.left = nodes[1];
            nodes[1] = root;
            return nodes;
        }else{
            TreeNode[] nodes = splitBST(root.right, target);
            root.right = nodes[0];
            nodes[0] = root;
            return nodes;
        }
    }
}