class Solution {
    public int thirdMax(int[] nums) {
        // distinguish return Max or return Third Max
        // how to find third max? -> make sorted and distinct array.
        Arrays.sort(nums);
        if(nums.length<3){
            return nums[nums.length-1];
        }
        int rank = 0;
        int candidate= Integer.MIN_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            if(candidate != nums[i]){
                candidate = nums[i];
                rank++;
            }
            if(rank == 3){
                return candidate;
            }          
        }
        return nums[nums.length-1];
    }
}