class Solution {
    public int findMin(int[] nums) {
        // 次の値が下がっていたらそこがminimum 
        // むしろ最初にそこを探してあげないといけない？
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;
        if(nums[left] < nums[right]){
            return nums[left];
        }
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[left] > nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}