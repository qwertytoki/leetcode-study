class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lenArray = new int[nums.length];
        Arrays.fill(lenArray, 1);
        for(int i =1;i<nums.length; i++){
            for(int j =0; j<i; j++){
                if(nums[i]> nums[j]){
                    lenArray[i] = Math.max(lenArray[j]+1, lenArray[i]);
                }
            }
        }
        int maxLen = 0;
        for(int i:lenArray){
            maxLen = Math.max(i, maxLen);
        }
        return maxLen;
    }
}