class Solution {
    // こっちのほうがわかりやすい、、

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        return robHelper(nums,0, nums.length-1);
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