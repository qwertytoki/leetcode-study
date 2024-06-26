class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total =0;
        int max = 0;
        for(int w:weights){
            total += w;
            max = Math.max(max, w);
        }
        int left = max;
        int right = total;
        
        while(left < right){
            int mid = (left + right)/2;
            if(canShip(weights, mid, days)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
        

    }

    private boolean canShip(int[]weights, int cap, int days){
        int actualDays = 1;
        int currentW = 0;
        for(int w :weights){
            currentW += w;
            if(currentW > cap){
                actualDays++;
                currentW = w;
            }
        }
        return actualDays <= days;
    }
}