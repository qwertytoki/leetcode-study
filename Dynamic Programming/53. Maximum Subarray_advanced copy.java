class Solution {
    private int[] nums;
    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return findBestSubarray(0, nums.length-1);

    }

    private int findBestSubarray(int left, int right){
        if(left > right){
            return Integer.MIN_VALUE;
        }
        int mid = (left -right)/2 + right;
        int current = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        for(int i = mid -1; i>= left; i--){
            current += nums[i];
            bestLeftSum = Math.max(bestLeftSum, current);
        }
        current = 0;
        for(int i = mid+1; i<=right; i++){
            current += nums[i];
            bestRightSum =  Math.max(bestRightSum, current);
        }
        int bestCombinedSum = nums[mid] + bestLeftSum + bestRightSum;
        int leftHalf = findBestSubarray(left, mid-1);
        int rightHalf = findBestSubarray(mid+1, right);

        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));    
    }
}