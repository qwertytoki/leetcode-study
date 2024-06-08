
class Solution {
    Map<Integer,Integer> inorderMap = new HashMap<>();
    int preorderIndex;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        preorderIndex = 0;
        for(int i = 0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildHelper(0,preorder.length-1);
        
    }
    private TreeNode buildHelper(int left, int right){
        if(left>right){
            return null;
        }
        int midValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode node = new TreeNode(midValue);
        int midIndexInorder = inorderMap.get(midValue);
        node.left = buildHelper(left, midIndexInorder -1);
        node.right = buildHelper(midIndexInorder +1, right);
        return node;
    }
}