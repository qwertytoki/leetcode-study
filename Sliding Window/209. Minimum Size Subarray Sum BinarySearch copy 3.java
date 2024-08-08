class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //prefixSum という0からn までのsum をもった配列を作る
        //→これはsortedArrayになるから、binarySearchが効く

        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for(int i = 0; i<n ;i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        int left =1;
        int right = n;
        int min = 0;
        while(left<= right){
            int mid = (left+right)/2;
            if(isValid(mid, target, prefixSum)){
                min = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return min;
    }

    private boolean isValid(int length, int target, int[] prefixSum){
        for(int i =0; i+length< prefixSum.length; i++){
            if(prefixSum[i+length]- prefixSum[i] >= target){
                return true;
            }
        }    
        return false;
    }
}