
class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int[] preorder;
    int currentPreIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i =0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(0, inorder.length-1);
    }

    private TreeNode arrayToTree(int left, int right){
        if(left>right) return null;
        int preValue = preorder[currentPreIndex];
        currentPreIndex++;
        TreeNode node = new TreeNode(preValue);
        node.left = arrayToTree(left, inorderMap.get(preValue)-1);
        node.right = arrayToTree(inorderMap.get(preValue)+1, right);
        return node;
    };

}