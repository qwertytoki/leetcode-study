class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConcCount = 0;
        int currConcCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                currConcCount++;
            }else{
                maxConcCount = compare(maxConcCount,currConcCount);
                currConcCount = 0;
            }
        }
        maxConcCount = compare(maxConcCount,currConcCount);
        return maxConcCount;
    }
    
    private int compare(int max, int current){
        return max >= current ? max : current;
    }
}