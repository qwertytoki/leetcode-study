class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length <3){
            return false;
        }
        int topIdx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[topIdx]<arr[i]){
                topIdx= i;
            }
        }
        for(int i=1;i<topIdx;i++){
            if(arr[i]==arr[topIdx]||arr[i]<=arr[i-1]){
                return false;
            }
        }
        for(int i=topIdx+1;i<arr.length;i++){
            if(arr[i]==arr[topIdx]||arr[i]>=arr[i-1]){
                return false;
            }
        }
        return true;
    }
}