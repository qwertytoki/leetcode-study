class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] maxRobbedAmount = new int[nums.length +1];
        maxRobbedAmount[n] = 0;
        maxRobbedAmount[n-1] = nums[n-1];
        for(int i = n-2; i>=0;i--){
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i+1], maxRobbedAmount[i+2] + nums[i]);
        }

        return maxRobbedAmount[0];
    }
}