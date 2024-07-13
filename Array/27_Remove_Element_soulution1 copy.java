class Solution {
    public int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        for(int i=0; i<nums.length;i++){
            while(i<nums.length && nums[i]==val){
                i++;
            }
            if(i<nums.length){
                nums[leftIndex++] = nums[i];
            }
        }
        return leftIndex;
    }
}