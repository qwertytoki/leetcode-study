class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //最高値と合計値のMidをとると積載可能日数が算出できる。
        //なぜかはまだ理解できていない
        int max = 0;
        int total = 0;
        for(int i:weights){
            max = Math.max(max,i);
            total += i;
        }
        while(max<total){
            int mid = (max+total)/2;
            
            if(calculateDays(weights,mid,days)){
                total = mid;
            }else{
                max = mid+1;
            }
        }
        return max;

    }

    private Boolean calculateDays(int[] weights, int target, int days){
        int currentDays = 1;
        int currentWeight = 0;
        for(int w:weights){
            currentWeight += w;
            if(currentWeight > target){
                currentDays++;
                currentWeight = w;
            }
        }
        return currentDays <= days;
    }
}