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
            int currentDays = calculateDays(weights,mid);
            if(currentDays == days){
                return mid;
            }
            if(currentDays < days){
                total = mid;
            }else{
                max = mid+1;
            }
        }
        return -1;

    }

    private int calculateDays(int[] weights, int target){
        int currentDays = 0;
        int currentWeight=0;
        for(int w:weights){
            currentWeight +=w;
            if(currentWeight > target){
                currentDays++;
                currentWeight = w;
            }
        }
        return currentDays;
    }
}