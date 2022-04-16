class Solution {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        for(int i=0;i<arr.length;i++){
            if(rightMax<=arr[i]){
                rightMax = getRightMax(i+1,arr);
            }
            arr[i] = rightMax;    
        }
        return arr;
    }
    
    private int getRightMax(int index,int[] arr){
        int rightMax = -1;
        for(int i = index;i<arr.length;i++){
            if(rightMax<arr[i]){
                rightMax = arr[i];
            }
        }
        return rightMax;
    }
}