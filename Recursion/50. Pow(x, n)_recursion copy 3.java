class Solution {
    public double myPow(double x, int n) {
        long nL = n;
        if(n <0){
            nL = n * -1;
            x = 1 / x;
        }

        return power(x, n);
    }

    private double power(double x, long n){
        if(n == 0){
            return 1;
        }
        double half = power(x, n/2);
        if(n % 2 ==0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}