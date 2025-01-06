
class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int distance = right - left;
            int currHeight = Math.min(height[left], height[right]);
            max = Math.max(max, currHeight * distance);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
