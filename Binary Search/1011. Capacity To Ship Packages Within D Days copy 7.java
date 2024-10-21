class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0, max = 0;
        for(int w:weights){
            total += w;
            max = Math.max(w,max);
        }
        int left = max;
        int right = total;
        while(left<=right){
            int mid = (left+right)/2;
            if(canShip(mid, weights, days)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean canShip(int capacity, int[] weights, int days){
        int currentDays = 1;
        int currentWeights = 0;
        for(int w : weights){
            currentWeights +=w;
            if(currentWeights>capacity){
                currentDays++;
                currentWeights = w;
            }
        }
        return currentDays <= days;
    }
}