class Solution {
    
    private Map<Integer,Integer> memo = new HashMap<>();
    public int numWays(int n, int k) {
        // 3色以上同じ色が続いてはならない
        // 考え方がわからない
        // 1「いくつの方法があるか」
        // 2 前の選択が、次の選択を左右する
        // こういう問題は ダイナミックプログラミングの特徴である。
        
        // <解き方>
        // 現在の状態を持つファンクションか配列を用意し、
        // 回帰関係を探る
        // メモ化して計算量を下げる
        
        return totalWays(n,k);
    }
    
    private int totalWays(int n, int k){
        if(n==1)return k;
        if(n==2)return k*k;
        
        if(memo.containsKey(n))return memo.get(n);
        
        //ここがキモ、ここがすべて
        memo.put(n,(k-1)*(totalWays(n-1,k) + totalWays(n-2, k)));
        return memo.get(n);
    }
    
}