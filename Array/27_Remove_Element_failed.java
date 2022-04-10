class Solution {
    public int removeElement(int[] nums, int val) {
        int valNumber = 0;
        for(int i = 0; i<=nums.length; i++){
            if(nums[i]==val){
                valNumber++;   
            }
        }
        int eIdx = nums.length - valNumber-1;
        
        
        
        for(int i = 0; i<=nums.length; i++){
            if(nums[i]==val){
                nums[i]==nums[eIdx];
                eIdx++;
            }
        }
    }
}