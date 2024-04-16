
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        this.preorder = preorder;
        inorderIndexMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(0, preorder.length-1);
    }

    private TreeNode arrayToTree(int left, int right){
        if(left>right){
            return null;
        }
        int currentVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode node = new TreeNode(currentVal);
        node.left = arrayToTree(left, inorderIndexMap.get(currentVal)-1);
        node.right = arrayToTree(inorderIndexMap.get(currentVal)+1, right);
        return node;
    }
}