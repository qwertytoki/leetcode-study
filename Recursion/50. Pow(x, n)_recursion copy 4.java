class Solution {
    public double myPow(double x, int n) {
        // 罠は2つ 
        // integerを超える数値の扱い
        // 普通に解くとtime exceedする
        long longN = n;
        if(n<0){
            x = 1/x;
            longN = -1 * longN;
        }
        return power(x,n);
    }

    private double power(double x, int n){
        if(n == 0){
            return 1;
        }
        double halfResult = power(x, n/2);
        if(n%2 == 0){
            return halfResult * halfResult;
        }else{
            return halfResult * halfResult * x;
        }
    }
}