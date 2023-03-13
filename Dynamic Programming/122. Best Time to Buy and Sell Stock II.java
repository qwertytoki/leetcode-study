class Solution {
    public int maxProfit(int[] prices) {
        //もし、次の値が前の値よりも下がったら買いを入れる
        //もし、次の値が前の値よりも下がったら一つ前で売りを入れる
        if(prices.length==1){
            return 0;
        }
        int buyPrice = prices[0];
        int profit = 0;
        for(int i = 1; i< prices.length;i++){
            if(prices[i]<prices[i-1]){
                profit += prices[i-1] - buyPrice;
                buyPrice = prices[i];
            }
        }
        profit += prices[prices.length-1] - buyPrice;
        return profit<0? 0: profit;
    }
}