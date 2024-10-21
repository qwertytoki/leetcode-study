class Solution {
    public void nextPermutation(int[] nums) {
        // 1 右から、始めてdecreaseする点Aをみつける
        // 2 左側でその点と一番近いA<Bとなる点Bを見つけ,swapする
        // 3 点Aより右側をascになるように並び替える
        int i = nums.length-2;
        //1
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>=0){ // i==-1ならそれより大きい値はないから最初に戻る
            int j = nums.length-1;
            while(nums[j]<= nums[i]){
                j--;
            }
            swap(nums, i,j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length -1;
        while(i<j){
            swap(nums, i,j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}