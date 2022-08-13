class Solution {
    public int lengthOfLIS(int[] nums) {
        // Dynamic Programmingの条件
        // 前の判断が次の判断に影響があるもの
        // 何通りあるかを聞かれる、 最大、最小を聞かれる
        
        // 回答用のArrayを用意し、nums.length分1をつめる
        // nums indexでfor文 
        // 各要素について、前までの要素を舐めるfor文(j)
        // 前までの要素jが自分より小さい数字だったら、
        // dp[i]にmax(dp[i],dp[j]+1)を入れる
        // max(dp)を返す
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i =0; i<nums.length;i++){
            for(int j = 0; j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int longest = 0;
        for(int i: dp){
            longest = Math.max(i,longest);
        }
        return longest;
        

    } 
}