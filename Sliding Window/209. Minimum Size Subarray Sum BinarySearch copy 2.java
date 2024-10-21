class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n+1];
        for(int i = 0; i<n;i++){
            sums[i+1] = sums[i] + nums[i];
        }
        int left = 1;
        int right = n;
        int min = 0;
        while(left<= right){
            int mid = (left + right)/2;
            if(isValid(mid, sums, target)){
                min = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return min;

    }

    private boolean isValid(int mid, int[] sums, int target){
        for(int i =0; i<sums.length-mid; i++){
            if(sums[i+mid]- sums[i] >= target){
                return true;
            }
        }
        return false;
    }
}