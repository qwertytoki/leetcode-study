class Solution {
    
    public int rob(int[] nums) {
        //iterative solution
        int len = nums.length;
        if(len == 0){
            return 0;
        }

        int[] maxRob = new int[len +1];
        maxRob[len] = 0;
        maxRob[len-1] = nums[len-1]; //終端の値を追加する

        for(int i = len-2; i>=0;i--){
            maxRob[i] = Math.max(maxRob[i+1], maxRob[i+2] + nums[i]);
        }

        return maxRob[0];
        
    }
}