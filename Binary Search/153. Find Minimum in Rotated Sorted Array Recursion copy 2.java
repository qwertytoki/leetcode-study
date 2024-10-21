class Solution {
    int[] nums;
    public int findMin(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        this.nums = nums;
        return findHelper(0, nums.length-1);
    }
    private int findHelper(int left, int right){
        if(left>=right){//必ず1つに収束するので、ここは>=をつかう
            return nums[left];
        }
        int mid = (left+right)/2 ;
        //必ず収束するのでここでmid条件でのreturnを書かなくても良い
    
        if(nums[mid]>nums[right]){
            return findHelper(mid+1, right);
        }else{
            return findHelper(left, mid);
        }
        
    }
}