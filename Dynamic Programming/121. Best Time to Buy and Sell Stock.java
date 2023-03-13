class Solution {
    public int maxProfit(int[] prices) {
        //現時点の最小値を保存しておく
        //現時点の最高利益を保存しておく
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price:prices){
            if(price<minPrice){
                minPrice = price;
            }else if(maxProfit<price-minPrice){
                maxProfit = price-minPrice;
            }
        }
        return maxProfit;
    }
}