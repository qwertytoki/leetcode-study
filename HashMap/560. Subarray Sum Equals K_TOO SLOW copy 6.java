class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            int sum = k;
            for(int j = i; j<nums.length; j++){
                sum -= nums[j];
                if(sum == 0){
                    count++;
                }
            }
        }
        return count;
    }
}