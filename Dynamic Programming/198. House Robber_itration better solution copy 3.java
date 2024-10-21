class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N==0){
            return 0;
        }
        int robNextNext = 0;
        int robNext = nums[N-1];
        for(int i = N-2; i>= 0; i--){
            int current = Math.max(robNext, robNextNext+ nums[i]);
            robNextNext = robNext;
            robNext = current;
        }
        return robNext;
    }
}