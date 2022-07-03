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

// 二分探索木 ： 子ノードにおいて、常に左が小さく、右が大きくなっているツリー。
class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        // 両端をわたしてあげることで処理時に真ん中を取れる
        this.nums = nums;
        return helper(0, nums.length -1);
    }
    private TreeNode helper(int left, int right){
        if(left>right){
            return null;  // これがあるから、Nodeが0でも抜けられる
        }
        int p = (left+right)/2;
        
        TreeNode node = new TreeNode(nums[p]);
        node.left = helper(left,p-1);
        node.right = helper(p+1, right);
        return node;
    }   
}