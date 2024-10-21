class Solution {
    public int kthGrammar(int n, int k) {
        /**
               0
           0       1
         0   1   1   0
        0 1 1 0 1 0 0 1
        親が0なら奇数:0 偶数:1
        親が1なら奇数:1 偶数:0

        0行目からではなく1行目から始まっているため、Parentのkは
        (k+1)/2となる
         */
        if(n ==1 || k==1){
            return 0;
        }
        int parent = kthGrammar(n-1, (k+1)/2);
        if(parent == 0){
            return k%2 == 0 ? 1 : 0;
        }else{
            return k%2 == 0 ? 0 : 1;
        }
    }
}