class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int t1 =0, t2 = 0;
        for(int i = 0; i<nums.length;i++){
            int current = Math.max(t1, t2 + nums[i]);
            t2 = t1;
            t1 = current;
        }
        return t1;
    }
}