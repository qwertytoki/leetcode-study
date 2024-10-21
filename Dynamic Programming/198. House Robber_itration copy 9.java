class Solution {
    public int rob(int[] nums) {
        int prevprev = 0;
        int prev = 0;
        for(int num:nums){
            int current = Math.max(prev, prevprev+num);
            prevprev = prev;
            prev = current;
        }
        return prev;
    }
}