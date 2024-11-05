
class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (price < prices[i]) {
                profit += prices[i] - price;
                price = prices[i];
            } else {
                price = prices[i];
            }
        }
        return profit;
    }
}
