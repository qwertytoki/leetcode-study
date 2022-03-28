class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        
        int startIdx = 0;
        int endIdx = nums.length - 1;
        
        while(startIdx != endIdx){
            int midIdx = (startIdx + endIdx)/2;
            if(nums[midIdx] == target ){
                return midIdx;
            }
            
            if(target > nums[midIdx]){
                if(target < nums[midIdx + 1]){
                    return midIdx;
                }else{
                    startIdx = midIdx + 1;
                }
            }
            if(target < nums[midIdx]){
                if(target > nums[midIdx -1] ){
                    return midIdx;
                }else{
                    endIdx = midIdx - 1;
                }
            }
        }
        if(startIdx == nums.length - 1){
            return nums.length;
        }else{
            return startIdx;    
        }
    }
}