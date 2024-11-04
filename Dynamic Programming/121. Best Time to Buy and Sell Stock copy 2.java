
class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}
