class Solution {
    public int rob(int[] nums) {
        int t1 = 0;
        int t2 = 0;
        for(int i=0; i<nums.length;i++){
            int current = Math.max(t1, t2+nums[i]);
            t2 = t1;
            t1 = current;
        }
        return t1;
    }
}