class Solution {
    public double myPow(double x, int n) {
        long nL = n; // Integer.MIN_VALUEを符号変換すると桁あふれするからLongに書き換えてる
        if(nL < 0){
            nL = -nL;
            x = 1/x;
        }
        double ans = 1;
        for(int i = 0;i<nL;i++){
            ans = ans * x;
        }
        return ans;
    }
}