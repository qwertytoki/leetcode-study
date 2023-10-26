class Solution {
    public int maxProfit(int[] prices) {
        int totalMax = 0;

        for(int i =1; i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                totalMax += prices[i]-prices[i-1];
            }
        }
        return totalMax;
    }
}