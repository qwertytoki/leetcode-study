class Solution {
    public int maxDepth(TreeNode root) {
        //itrative way
        //1 prepare 2 Stack, for TreeNode and for depth
        //2 while Stack is not empty...
        //3 if currentNode is not null, then compare maxDepth
        //4 put right and left to Stack if they exist.
        //5 put the current depth to depth-stack
        

        if(root == null){
            return 0;
        }
        //1 
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);

        int maxDepth = 0;
        int currentDepth = 0;

        //2
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            currentDepth = depths.pop();
            if(node != null){
                //3 
                maxDepth = Math.max(maxDepth,currentDepth);
                //4
                stack.push(node.left);
                stack.push(node.right);
                //5
                depths.push(currentDepth+1);
                depths.push(currentDepth+1);
            }
        }
        return maxDepth;

    }
}