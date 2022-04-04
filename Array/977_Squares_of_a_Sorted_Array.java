class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedSquaredArray = new int[nums.length];
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        for(int i = nums.length-1; i >= 0; i--){
            int leftVal = nums[leftPointer];
            int rightVal = nums[rightPointer];
            if(Math.abs(leftVal) <= Math.abs(rightVal)){
                sortedSquaredArray[i] = rightVal * rightVal;
                rightPointer--;
            }else{
                sortedSquaredArray[i] = leftVal * leftVal;
                leftPointer++;
            }
        }
        return sortedSquaredArray;
    }
}