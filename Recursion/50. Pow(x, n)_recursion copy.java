class Solution {
    public double myPow(double x, int n) {
        long nL = n;
        if(nL < 0){
            nL = -nL;
            x = 1/x;
        }
        return power(x, nL);
    }

    private double power(double x, long nL){
        if(nL==0){
            return 1;
        }
        double half = power(x, nL/2);
        if(nL%2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}