class Solution {
    public int kthGrammar(int n, int k) {
        /**
        0 
        01
        0110
        01101001
        0110100110010110
        if parent is 0 : even:1 odd:0
        if parent is 1 : even:0 odd:1
        */
        if(n == 1 || k ==1){
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