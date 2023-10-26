class Solution {
    public int maxProfit(int[] prices) {
        int totalMax = 0;
        int current = Integer.MAX_VALUE;
        for(int i : prices){
            if(current < i){
                totalMax += i - current;
                current = i;
            }else{  
                current = i;
            }
        }
        return totalMax;
    }
}


