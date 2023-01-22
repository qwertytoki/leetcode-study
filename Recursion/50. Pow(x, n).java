class Solution {
    // brute forces
    public double myPow(double x, int n) {
        
        // reverse if n < 0
        // loop
        //   multiply
        // loop end

        if(n<0){
            x = 1/x;
            n = -n;
        }
        double answer = 1;
        for(int i =0;i<n;i++){
            answer = answer * x;
        }
        return answer;
    }
}