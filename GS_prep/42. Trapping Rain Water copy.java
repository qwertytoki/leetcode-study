class Solution {
    public int trap(int[] height) {
        int ans = 0, current =0;
        Stack<Integer> st = new Stack<>();
        while(current< height.length){
            while(!st.isEmpty() && height[current] > height[st.peek()]){
                int top = st.peek();
                st.pop();
                if(st.isEmpty()) break;
                int distance = current-st.peek()-1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }
}