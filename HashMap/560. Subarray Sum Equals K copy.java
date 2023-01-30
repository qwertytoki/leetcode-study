class Solution {
    //brute forces
    public int subarraySum(int[] nums, int k) {
        //1 for loop by nums
        //2 k - minus num
        //3 if k == 0, answer ++, 
        int answer = 0;
        for(int start = 0; start< nums.length; start++){
            for(int end = start + 1; end<= nums.length; end++){
                int sum = 0;
                for(int i = start; i < end; i++){
                    sum += nums[i];
                }
                if(sum == k) answer++;
            }
        }
        return answer;
    }

    
}