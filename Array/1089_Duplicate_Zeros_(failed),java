class Solution {
    public void duplicateZeros(int[] arr) {
        
        int[] nums = new int[arr.length];
        int pointer = 0;
        for(int i=0;i<= arr.length; i++){
            if(arr[i]==0){
                if(pointer>=arr.length){
                    arr = nums;
                    return;
                }else{
                    nums[pointer]=0;
                    pointer++;
                }
                if(pointer>=arr.length){
                    arr = nums;
                    return;
                }else{
                    nums[pointer]=0;
                    pointer++;
                }
            }else{
                if(pointer>=arr.length){
                    arr = nums;
                    return;
                }else{
                    nums[pointer]=0;
                    pointer++;
                }
            }
        }
        arr = nums;   
    }
}