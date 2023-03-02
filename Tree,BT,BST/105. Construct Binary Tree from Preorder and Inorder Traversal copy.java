class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 全くわからない
        // 1 preorderはrootが始点なので、それと同一の値がinorderのルートになる
        // 2 rootからinorderの右と左を知る 
        // あとは1 2を繰り返す
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length-1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode node = new TreeNode(rootValue);
        node.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        node.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);
        return node;
    }
}