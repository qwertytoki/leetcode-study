class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i< nums.length; i++){
            int target = k;
            for(int j = i; j < nums.length; j++){
                target -= nums[j];
                if(target == 0){
                    result++;
                }
            }
        }
        return result;
    }
}
