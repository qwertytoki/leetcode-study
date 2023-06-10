class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            int remain = k;
            int j = i;
            while(j<nums.length){
                remain -= nums[j];
                j++;
                if(remain == 0){
                    count++;
                }
            }
        }
        return count;
    }
}