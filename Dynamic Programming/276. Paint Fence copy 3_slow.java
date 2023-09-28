class Solution {
    public int numWays(int n, int k) {
        //this is correct, but slow;
        if(n ==1){
            return k;
        }
        if(n == 2){
            return k*k;
        }
        // n-1 and n is different color -> (k-1)* calcWays(n-1,k);
        // n-1 and n is same,but n-2 and n is different -> (k-1) * calcWays(n-2,k);
        return (k-1) * numWays(n-1,k) + (k-1)* numWays(n-2, k);
    }
}