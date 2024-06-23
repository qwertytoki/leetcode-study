class Solution {
    public int maxSubArray(int[] nums) {
        //divide and concur
        return divide(0, nums.length-1, nums);
    }

    private int divide(int left, int right, int[] nums){
        if(left>right){
            return Integer.MIN_VALUE;
        }

        int mid = (left+right)/2;
        int leftMax = 0; 
        int rightMax = 0;
        int current = 0;

        for(int i = mid-1; i>=left; i--){
            current += nums[i];
            leftMax = Math.max(leftMax, current);
        }
        current = 0;
        for(int i = mid+1; i<= right;i++){
            current += nums[i];
            rightMax = Math.max(rightMax, current);
        }
        int midMax = leftMax + nums[mid] + rightMax;
        leftMax = divide(left, mid-1, nums);
        rightMax = divide(mid+1, right, nums);
        return Math.max(midMax, Math.max(leftMax, rightMax));
    }
}