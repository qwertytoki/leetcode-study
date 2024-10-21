class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null ){
            return new TreeNode[]{null,null};
        }
        if(target < root.val){
            // 左を切る
            TreeNode[] nodes = splitBST(root.left, target); // node[0]には切った左側 node[1]には右側
            root.left = nodes[1]; //ここにはroot.left内の大きいものが入っている. nodes[0]はすでに左側の切った部分で確定
            nodes[1] = root; //node[2]はroot全部(leftはすでに切り済)を入れてあげないといけない
            return nodes;
        }else{
            // 右を切る 
            TreeNode[] nodes = splitBST(root.right, target);
            root.right = nodes[0];
            nodes[0] = root;
            return nodes;
        }
    }
}