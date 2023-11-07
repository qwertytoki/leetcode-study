class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxW = 0;
        int totalW = 0;
        
        for(int w :weights){
            maxW = Math.max(maxW, w);
            totalW +=w;
        }
        while(maxW < totalW){
            int mid = maxW + (totalW - maxW)/2;
            if(canShip(weights, days, mid)){
                totalW = mid;       
            }else{
                maxW = mid +1;
            }
        }
        return maxW;
    }

    private boolean canShip(int[] weights, int maxDays, int max){
        int days = 1;
        int currentW = 0;
        for(int w :weights){
            if(currentW + w > max){
                days++;
                currentW = w;
            }else{
                currentW += w;
            }
        }
        return days <= maxDays;
    }
}