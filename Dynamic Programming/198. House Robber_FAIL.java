class Solution {
    public int rob(int[] nums) {
        //答えは奇数の和か偶数の和しかありえなくない？ →間違っている
        int oddSum = 0;
        int evenSum = 0;
        for(int i = 0; i< nums.length; i++){
            if(i%2==0){
                evenSum += nums[i];
            }else{
                oddSum += nums[i];
            }
        }

        return Math.max(oddSum, evenSum);
    }
}