class Solution {
    public int kthGrammar(int n, int k) {
        //親が0なら子は奇数：0 偶数：1
        //親が1なら子は奇数：1 偶数：0

        if(n== 1 || k ==1){
            return 0;
        }
        int parent = kthGrammar(n-1, (k+1)/2);

        boolean isEven = k%2 ==0;
        if(parent == 0){
            return isEven ? 1 : 0;
        }else{
            return isEven ? 0 : 1;
        }

    }
}

// time O(n)
// space O(1)