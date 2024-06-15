class Solution {
    public double myPow(double x, int n) {
        long nL = n;
        if(nL<0){
            x = 1/x;
            nL = -1 * n;
        }
        return power(x, nL);
    }
    private double power(double x, long n){
        if(n == 0){
            return 1;
        }
        double half = power(x, n/2);
        if(n%2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}