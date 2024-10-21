class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left =0;
        int right =0;
        for(int w : weights){
            left = Math.max(w, left);
            right += w;
        }
        while(left<right){
            int mid = (left+right)/2;
            if(canShip(mid, days, weights)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean canShip(int max, int days, int[] weights ){
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