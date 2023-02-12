class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        //0 corner case
        //1 pick the middle value.
        //2 always pick left if the length is even
        //3 recursion for left value
        //4 recurison for right value
        //5 return TreeNode

        this.nums = nums;
        return generateBST(0, nums.length-1);
    }

    private TreeNode generateBST(int left, int right){
        //0
        if(left > right){
            return null;
        }
        TreeNode node = new TreeNode();
        //1,2
        int center = (left+right)/2;
        node.val = nums[center];
        //3
        node.left = generateBST(left, center-1);
        //4
        node.right = generateBST(center+1, right);
        //5
        return node;
    }
}