class Solution {
    int[] nums;
    public int maxSubArray(int[] nums) {
        // Divide and Conquer
        // 3つに分けて、左と、右と、真ん中で戦わせるアプローチ
        this.nums = nums;
        return findMaxSubArray(0, nums.length-1);

    }

    private int findMaxSubArray(int left, int right){
        if(left > right){
            return Integer.MIN_VALUE;
        }
        int mid = (left+right)/2;
        int leftSumMax = 0;
        int rightSumMax = 0;

        // generate left sum (need to include right end)
        int current = 0;
        for(int i = mid-1; i>=left; i--){
            current += nums[i];
            leftSumMax = Math.max(current,leftSumMax);
        }

        // generate right sum (need to include left end)
        current = 0;
        for(int i = mid+1; i<=right; i++){
            current += nums[i];
            rightSumMax = Math.max(current, rightSumMax);
        }
        int middleSumMax = leftSumMax + nums[mid] + rightSumMax;
        int leftVal = findMaxSubArray(left, mid-1);
        int rightVal = findMaxSubArray(mid+1, right);
        return Math.max(middleSumMax, Math.max(leftVal, rightVal));
    }
}