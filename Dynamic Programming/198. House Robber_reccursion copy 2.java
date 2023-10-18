class Solution {
    //メモリ最適化バージョン
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int[] result = new int[nums.length];
        int twoHouseBack = nums[0];
        int oneHouseBack = Math.max(nums[0], nums[1]);
        for(int i =2; i< nums.length; i++){
            int current = Math.max(twoHouseBack+nums[i], oneHouseBack);
            twoHouseBack = oneHouseBack;
            oneHouseBack = current;
        }
        return oneHouseBack;

    }
}