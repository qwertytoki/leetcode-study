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
    public TreeNode sortedArrayToBST(int[] nums) {
        //1 pick the center and put it to Node
        //2 divide 2 arrays
        //3 pick the center and put it to Node
        //4 divide 2 arrays
        //  ...
        
        TreeNode result = new TreeNode();
        if(nums.length ==0){
            return result;
        }
        int center = nums.length/2;
        result.val = nums[center]; 
        return result;


    }

    private void generateBST(int[] nums, TreeNode result){
        
    }
}










