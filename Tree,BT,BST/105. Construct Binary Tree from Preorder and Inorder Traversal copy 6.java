
class Solution {
    int[] preorder;
    Map<Integer, Integer> inorderMap;
    int preorderTop = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // マップを構築する
        // preorderは常にTopを指す
        // inorderのTopはつねに中心を位置する
        this.preorder = preorder;
        inorderMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildHelper(0, preorder.length-1);
    }

    private TreeNode buildHelper(int left, int right){
        if(left>right){
            return null;
        }
        int topValue = preorder[preorderTop];
        preorderTop++;
        int inorderTopIndex = inorderMap.get(topValue);
        TreeNode node = new TreeNode(topValue);
        node.left = buildHelper(left, inorderTopIndex-1);
        node.right = buildHelper(inorderTopIndex+1, right);
        return node;         
    }                   
}