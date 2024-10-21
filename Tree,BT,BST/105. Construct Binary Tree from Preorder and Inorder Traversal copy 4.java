
class Solution {
    int[] preorder;
    int preorderIndex = 0;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return arrayToNode(0, inorder.length-1);
    }

    private TreeNode arrayToNode(int left, int right){
        if(left>right){
            return null;
        }
        int currentVal = preorder[preorderIndex];
        preorderIndex++;
        int inorderIndex = inorderMap.get(currentVal);
        TreeNode node = new TreeNode(currentVal);
        node.left = arrayToNode(left, inorderIndex-1);
        node.right = arrayToNode(inorderIndex+1, right);
        return node;
    }
}