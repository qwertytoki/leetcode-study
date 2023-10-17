class Solution {
    int[] nums;
    public int rob(int[] nums) {
        //0を通るバージョンと、1を通るバージョン両方考える
        if(nums.length ==1 ) return nums[0];
        this.nums = nums;
        int rob1 = robHelper(0, nums.length-2);
        int rob2 = robHelper(1, nums.length-1);
        return Math.max(rob1, rob2);
    }

    private int robHelper(int start, int end){
        int t1 =0;
        int t2 =0;

        for(int i =start; i<=end; i++){
            int temp = t1;
            int current = nums[i];

            t1 = Math.max(t1, t2 + current);
            t2 = temp;
        }
        return t1;
    }
}