class Solution {
    public int subarraySum(int[] nums, int k) {
        // 1 for loop and create sum from 0
        // 2 for loop define start
        // 3 for loop define end 
        // 4 sum = sum[end] - sum[start]
        // 5 return count

        int count = 0;
        //1
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length;i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        //2
        for(int start =0; start< nums.length; start++){
            //3
            for(int end = start +1; end <= nums.length; end++){
                //4
                if(sum[end] - sum[start] == k) count ++;
            }
        }
        //5
        return count; 
    }
}