class Solution {
    public int kthGrammar(int n, int k) {
        /**
        0
        0 1
        0 1 1 0
        01101001
         */
         if(n==1 || k == 1){
            return 0;
         }
         int parent = kthGrammar(n-1, (k+1)/2);
         if(parent ==0){
            return k%2==0 ? 1 : 0;
         }else{
            return k%2==0 ? 0 : 1;
         }
    }
}