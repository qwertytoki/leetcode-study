class Solution {
    public int rob(int[] nums) {
        //houseを2つ飛ばす場合もあることに注意しないといけない
        // 14 1 1 12 みたいなケースのとき 
        // 逆に、3つ飛ばすケースは存在しない。真ん中を取っちゃえばいいから
        // つまり 1つ飛ばすor 2つ飛ばす場合の最大値を求める。

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(nums.length == 3){
            return Math.max(nums[1], nums[0]+nums[2]);
        }

        int[] maxRobs = new int[nums.length];
        maxRobs[0] = nums[0];
        maxRobs[1] = nums[1];
        maxRobs[2] = nums[0] + nums[2];
        for(int i = 3; i<nums.length;i++){
            maxRobs[i] = Math.max(maxRobs[i-3], maxRobs[i-2]) + nums[i];
        }

        return Math.max(maxRobs[nums.length-1],maxRobs[nums.length-2]);
    }
}