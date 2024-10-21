class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] max = new int[len+1];
        max[len] = 0;
        max[len-1] = nums[len-1];
        for(int i = len-2; i>=0; i--){
            max[i] = Math.max(max[i+1], max[i+2]+ nums[i]);
        }
        return max[0];   
    }
}
