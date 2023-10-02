class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 重り内の最大値が下限、重りの合計値が上限になる。
        // (重り内の最大値を下回る場合、絶対に運べないから。 また合計値を上回れば、絶対1日で運べる)
        // その上限下限のうち、下限に最も近い、かつ達成可能な重さを探す問題 、→つまりバイナリサーチ
        int total = 0;
        int max = 0;
        for(int i : weights){
          max = Math.max(max, i);
          total += i;
        }
        while(max < total){
          int mid = (max+total) /2;
          if(feasible(weights, mid, days)){
            total = mid;
          }else{
            max = mid +1;
          }
        }
        return max;
    }

    private boolean feasible(int[] weights, int max, int days){
      int currDays = 1;
      int currWeight = 0;
      for(int i : weights){
        currWeight += i;
        if(currWeight > max){
          currWeight = i;
          currDays++;
        }
      }
      return currDays <= days;
    }
}