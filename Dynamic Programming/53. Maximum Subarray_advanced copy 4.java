class Solution {
    int[] nums;
    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return divideAndConcur(0, nums.length-1);
    }

    private int divideAndConcur(int left, int right){
        if(left>right){
            return Integer.MIN_VALUE;
        }
        int mid = (left+right)/2;
        int leftMax = 0;
        int current = 0;
        for(int i= mid-1; i>=left;i--){
            current += nums[i];
            leftMax = Math.max(leftMax, current);
        }
        int rightMax = 0;
        current = 0;
        for(int i =mid+1; i<=right;i++){
            current += nums[i];
            rightMax = Math.max(current, rightMax);
        }
        int midMax = leftMax + nums[mid] + rightMax;
        leftMax = divideAndConcur(left, mid-1);
        rightMax = divideAndConcur(mid+1, right);
        return Math.max(midMax, Math.max(leftMax, rightMax));
    }
}