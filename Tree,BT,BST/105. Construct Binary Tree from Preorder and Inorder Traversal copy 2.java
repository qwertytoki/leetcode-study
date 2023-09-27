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

// preorderはtopがrootになることを
// inorderはrootを境に左すべてがtree.left 右すべてがtree.rightにいく
// この2つの特徴を利用してTreeを構築する
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorderIndex= 0;
        this.inorderMap = new HashMap<>();
        for(int i=0;i< inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        return arrayToTree(preorder,0, preorder.length-1);

    }

    private TreeNode arrayToTree(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }
        int currentVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode node = new TreeNode(currentVal);
        node.left = arrayToTree(preorder, start, inorderMap.get(currentVal)-1);
        node.right = arrayToTree(preorder, inorderMap.get(currentVal)+1, end);
        return node;
    }
}