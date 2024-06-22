
class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }

    private TreeNode helper(int left, int right){
        if(left>right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(left, mid-1);
        node.right = helper(mid+1, right);
        return node;
    }
}