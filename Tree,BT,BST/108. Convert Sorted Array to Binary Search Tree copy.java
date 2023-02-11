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
    int nums[];
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return generateBST(0, nums.length-1);
    }

    private TreeNode generateBST(int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode node = new TreeNode();
        node.val = nums[mid];
        node.left = generateBST(left,mid-1);
        node.right = generateBST(mid+1,right);
        return node;
    }
}