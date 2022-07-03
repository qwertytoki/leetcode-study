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

// 解法が全然思いつかない
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //真ん中の値を中心に据える。真ん中がない場合は−1する
        //左半分の真ん中をleft 右半分の真ん中をRight
        //以降それを繰り返す
        TreeNode node = new TreeNode();
        return dfs(nums, node);
    }
    private TreeNode dfs(int[] nums, TreeNode node){
        if(node == null || nums.length < 2){
            return node;
        }
        int center = (nums.length-1)/2;
        node.val = nums[center];
        int[] leftNums = Arrays.copyOfRange(nums,0,center-1);
        int[] rightNums = Arrays.copyOfRange(nums,center,nums.length-1);
        node.left= dfs(leftNums, node);
        node.right= dfs(rightNums, node);
        return node;
    }
    
}