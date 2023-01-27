class Solution {
    
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null){
            return new TreeNode[]{null,null};
        }
        if(target >= root.val){
            // 右側でSplitを起こすパターン
            TreeNode[] node = splitBST(root.right,target);
            root.right = node[0]; //nodeはTargetでSplitした結果なので、node[0]にはsplit後のデータが入ってる(はず)
            node[0] = root; //node[0]はroot.rightにsplitした結果を突っ込んだものを入れるべきなので、rootを入れられる
            return node; //で,そのnodeを返す
        } else{
            //左側でSplitを起こすパターン
            TreeNode[] node = splitBST(root.left, target);
            root.left = node[1];
            node[1] = root;
            return node;
        }
    }
}