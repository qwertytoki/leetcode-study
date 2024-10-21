
class Solution {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        int preIndex = 0;
        return buildHelper(0, preorder.length-1, preorder, inorderMap);
        
    }
    private TreeNode buildHelper(int left, int right, int[] preorder, Map<Integer, Integer> inorderMap){
        if(left>right){
            return null;
        }
        int currentTopValue = preorder[preIndex];
        preIndex++;
        TreeNode node = new TreeNode(currentTopValue);
        int inorderIndex = inorderMap.get(currentTopValue);
        node.left = buildHelper(left, inorderIndex-1, preorder, inorderMap);
        node.right = buildHelper(inorderIndex+1, right, preorder, inorderMap);
        return node;
    }
}