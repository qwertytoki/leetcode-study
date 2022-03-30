class Solution {
    public int findNumbers(int[] nums) {
        int evenNumber = 0;
        for(int i = 0; i< nums.length; i++){
            int digit = 0;
            int target = nums[i];
            while(target != 0){
                target= target/10;
                digit++;
            }
            if(digit % 2 == 0){
                evenNumber++;
            }
        }
        return evenNumber;
    }
}