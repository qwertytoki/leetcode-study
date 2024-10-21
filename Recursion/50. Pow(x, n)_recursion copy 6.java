class Solution {
    public double myPow(double x, int n) {
        long nLong = n;
        if(n<0){
            x = 1/x;
            nLong = nLong * -1;
            
        }
        return power(x, nLong);
    }

    private double power(double x, long nLong){
        if(nLong ==0){
            return 1;
        }
        double half = power(x, nLong/2);
        if(nLong %2 ==1){
            return half * half * x;
        }else{
            return half * half;
        }
    }
}