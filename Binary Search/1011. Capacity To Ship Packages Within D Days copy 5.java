class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; // max
        int right = 0; // total
        
        for(int w:weights){
            left = Math.max(left, w);
            right += w;
        }
        
        while(left<right){
            int mid = (left+right)/2;
            if(canShip(weights, mid, days)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int max, int days){
        int currentDays = 1;
        int currentWeight = 0;
        for(int w : weights){
            currentWeight += w;
            if(currentWeight>max){
                currentDays++;
                currentWeight = w;
            }
        }
        return currentDays <= days;
    }
}