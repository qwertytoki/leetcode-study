class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length+1];
        for(int i =0; i< nums.length; i++){
            sums[i+1] = sums[i] + nums[i];
        }   
        int left = 0;
        int right = nums.length;
        int min = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(isValid(mid, target, sums)){
                min = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return min;
    }

    private boolean isValid(int length, int target, int[]sums){
        for(int i = 0; i+length < sums.length; i++){
            if(sums[i+length]- sums[i]>= target){
                return true;
            }
        }
        return false;
    }
}