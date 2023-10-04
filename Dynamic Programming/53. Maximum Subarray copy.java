class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int total = 0;

        for(int num:nums){
            max = Math.max(max, num);
            total += num;
            if(total <0){
                total = 0;
                continue;
            }
            max = Math.max(max, total);
        }
        return max;
    }
}