class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max1 = robHelper(nums,0,nums.length-2);
        int max2 = robHelper(nums,1,nums.length-1);

        return Math.max(max1,max2);

    }

    private int robHelper(int[] nums, int start, int end){
        int t1 =0, t2 = 0;
        for(int i = start; i<=end;i++){
            int current = Math.max(t1, t2 + nums[i]);
            t2 = t1;
            t1 = current;
        }
        return t1;
    }
}