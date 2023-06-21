// Always pick left middle as root
class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return generateBST(0, nums.length-1);
    }

    private TreeNode generateBST(int left, int right){
        if(left > right) return null;
        int mid = (left + right) /2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generateBST(left, mid-1);
        node.right = generateBST(mid+1, right);
        return node;
    }
}