class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N==0){
            return 0;
        }
        int[] maxRob = new int[nums.length +1];
        maxRob[N] = 0;
        maxRob[N-1] = nums[N-1];
        for(int i = N-2; i>= 0; i--){
            maxRob[i] = Math.max(maxRob[i+1], maxRob[i+2]+ nums[i]);
        }
        return maxRob[0];
    }
}