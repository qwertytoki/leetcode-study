class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // スライドさせていく. 左を記憶しておく totalを記憶する
        // targetをこえるまでは右を動かす。 超えたらtarget未満になるまで左を動かす

        int len = nums.length;
        int result = Integer.MAX_VALUE;
        int total = 0;
        int left = 0, right = 0; 
        while(right<len){
            total += nums[right];
            while(total >= target){
                result = Math.min(result, right-left+1);
                total -= nums[left++];
            }
            right++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}