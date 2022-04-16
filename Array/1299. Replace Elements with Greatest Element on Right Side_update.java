class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int currentVal = -1;
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            currentVal = arr[i];
            if(i == n-1){
                arr[i]=-1;
            }else{
                arr[i]= max;
            }
            max = Math.max(currentVal,max);
        }
        return arr;
    }
}