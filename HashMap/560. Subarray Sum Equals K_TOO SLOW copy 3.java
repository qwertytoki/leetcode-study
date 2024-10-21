class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int current = k;
            for(int j = i;j<nums.length;j++){
                current -= nums[j];
                if(current == 0){
                    count++;
                }
            }
        }
        return count;
    }
}