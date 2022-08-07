class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 一番軽い場合(左)はmax(weights)
        // 一番重い場合(右)はsum(weights)
        // バイナリサーチで真ん中を取っていく。重さが真ん中を超えたらcurrent daysを1つ足す
        // current daysがdaysを超えたら左に、余裕があれば右に移動する
        
        int left =0;
        int right = 0;
        for(int w : weights){
            left = Math.max(left,w);
            right += w;
        }
        while(left<right){
            int mid = (left + right)/2;
            int currDays = 1;
            int currWeights = 0;
            
            for(int w:weights){
                if(currWeights + w > mid){
                    currDays ++;
                    currWeights= 0;
                }
                currWeights += w;
            }
            if(currDays>days){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
        
    }
}