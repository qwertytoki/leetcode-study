class Solution {
    public int kthGrammar(int n, int k) {
        // 1 corner case
        // 2 get parent
        // 3 parent == odd
        // 4 parent == even

        // 1
        if(n==1 || k ==1){
            return 0;
        }
        // 2
        int parent = kthGrammar(n-1,k/2 +(k%2));
        
        // 3
        boolean isEven = k % 2 ==0;
        if(parent % 2 == 0){
            if(isEven) return 1;
            else return 0;
        }else{
        // 4     
            if(isEven) return 0;
            else return 1;
        }
    }
}