class Solution {
    public int findMin(int[] nums) {
        // 折返し点を探す作業
        // 中間地点を見つけて、中間地点の前後に折返しがないか確認
        // なければ、左右どちらを残すかを判断する
        if(nums.length == 1 ){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<nums[right]){
            return nums[0];
        }
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]>nums[middle+1]){
                return nums[middle+1];
            }
            if(nums[middle-1] > nums[middle]){
                return nums[middle];
            }
            if(nums[left]>nums[middle]){
                right = middle-1;
            }else{
                left = middle +1;
            }
        }
        return 1; 
    }
}