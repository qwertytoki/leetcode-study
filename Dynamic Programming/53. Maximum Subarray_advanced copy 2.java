class Solution {
    int[] nums;
    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return findMax(0,nums.length-1);
    }

    private int findMax(int left, int right){
        if(left> right){
            return Integer.MIN_VALUE;
        }
        int mid = (left-right)/2+right;
        int current = 0;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = mid-1; i>= left; i--){
            current += nums[i];
            leftMax = Math.max(leftMax, current);
        }
        current = 0;
        for(int i = mid+1; i<= right; i++){
            current += nums[i];
            rightMax = Math.max(rightMax, current);
        }
        int midMax = leftMax + nums[mid] + rightMax;
        leftMax = findMax(left, mid-1);
        rightMax = findMax(mid+1, right);
        return Math.max(midMax, Math.max(leftMax, rightMax));
    }


}