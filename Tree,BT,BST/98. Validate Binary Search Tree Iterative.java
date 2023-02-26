
class Solution {
    // Iterative traversal with valid range
    private Deque<TreeNode> stack = new LinkedList<>();
    private Deque<Integer> upperLimits = new LinkedList<>();
    private Deque<Integer> lowerLimits = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        Integer low = null;
        Integer high = null;
        Integer val;
        update(root, low, high);
        while(!stack.isEmpty()){
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();
            if(root == null) continue;
            val = root.val;
            if(low != null && val <= low ){
                return false;
            }
            if(high != null && val >= high){
                return false;
            }
            update(root.left, low, val);
            update(root.right, val, high);
        }
        return true;
    }

    private void update(TreeNode node, Integer low, Integer high){
        stack.add(node);
        upperLimits.add(high);
        lowerLimits.add(low);
    }
}