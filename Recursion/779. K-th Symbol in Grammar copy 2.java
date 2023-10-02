class Solution {
    public int kthGrammar(int n, int k) {
        // 1:0 
        // 2:01
        // 3:0110
        // 4:01101001
        // 5:0110100110010110
        if(n==1 || k ==1){
            return 0;
        }
        int parent = kthGrammar(n-1, (k+1)/2);
        boolean isEven = (k%2 == 0);
        if(parent == 0){
            return isEven? 1 : 0;
        }else{
            return isEven? 0 : 1;
        }

    }
}