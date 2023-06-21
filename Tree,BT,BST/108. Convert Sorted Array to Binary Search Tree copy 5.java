// random pick root
class Solution {
    int[] nums;
    Random rand = new Random();
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }

    private TreeNode helper(int left, int right){
        if(left >right) return null;
        int mid = (left + right) /2;
        if((left + right)%2 ==1){
            rand.nextInt(2); // I didn`t know this way...
        }

        TreeNode node = new TreeNode(nums[mid]);
        node.left= helper(left, mid-1);
        node.right = helper(mid+1, right);
        return node;
    }
}