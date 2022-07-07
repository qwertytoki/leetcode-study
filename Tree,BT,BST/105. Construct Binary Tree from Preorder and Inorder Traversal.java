/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorderIndex=0;
    Map<Integer,Integer> inorderIndexMap = new HashMap<>();
        
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // preorderは最初の値がRootになる
        // inorderはRootからみて左側がすべてleftNode, 右側がすべてrightNodeになる
        // この2つの特性をつかってTreeを作成していく
        // Rootをみつけて、左と右をわける、を繰り返す
        
        for(int i = 0; i< inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return arrayToTree(preorder,0,preorder.length-1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left>right) return null;
        
        int rootValue = preorder[preorderIndex++];
        TreeNode node = new TreeNode(rootValue);
        
        node.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        node.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);
        return node;
    }
}