class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>k) continue;
            int sum = 0;
            int j = i;
            while(sum<k && j< nums.length){
                sum += nums[j];
                if(sum==k)count++;
                j++;
            }
        }
        
        return count;
    }
}