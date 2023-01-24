class Solution {
    // iteration
    public double myPow(double x, int n){
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        double answer = 1;
        for(long i = N; i>0; i = i/2){
            if(i % 2 == 1){
                answer = answer * x;
            }
            x = x * x;
        }
        return answer;
    }
}