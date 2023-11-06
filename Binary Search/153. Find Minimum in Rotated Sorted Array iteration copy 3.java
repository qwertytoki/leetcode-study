class Solution {
    public int findMin(int[] nums) {
        // binary tree
        int left = 0;
        int right = nums.length-1;
        if(nums.length == 1 || nums[left]<nums[right]){
            return nums[left]; // no rotation
        }
        if(nums.length ==2){
            return nums[1];
        }

        while(left <= right){
            int mid = (left + right) /2;
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[mid] > nums[right]){
                left = mid+1; // 谷はmid よりも右側にある、 midは答えになり得ないので+1する
            }else{
                right = mid; // 谷はmidよりも左にある。 midは答えになる可能性があるので、-1しない
            }
        }
        return -1;

    }
}