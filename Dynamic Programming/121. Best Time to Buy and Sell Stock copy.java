class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int totalMax = 0;
        for(int i : prices){
            if(i < min){
                min = i;
            }else{
                totalMax = Math.max(totalMax, i - min);
            }
        }
        return totalMax;
    }
}