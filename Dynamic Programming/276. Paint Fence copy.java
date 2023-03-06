class Solution {
    
    private Map<Integer,Integer> memo = new HashMap<>();
    public int numWays(int n, int k) {
        // 1「いくつの方法があるか」
        // 2 前の選択が、次の選択を左右する
        // こういう問題は ダイナミックプログラミングの特徴である。
        
        // n=1 n=2のときはそれぞれ静的に答えが出るので先に処理
        // n>=3 のケースをロジック化する
        // n>=3 の場合
        // A 1つ前と違う色を使うケース -> (k-1)色 * totalWays(n-1) 通り
        // B 1つ前と同じ色を使うケース -> 1色 * totalWays(n-1) 通り のはずだが、
        // 同じ色は3回連続使ってはいけないので、 Bは(k-1)色 * totalWays(n-2) 通り
        // つまりAとBの組み合わせにより、 
        // n>=3 の場合 (k-1)(totalWays(n-1) + totalWays(n-2)) 通り となる
        return totalWays(n,k);
    }
    
    private int totalWays(int n, int k){
        if(n==1)return k;
        if(n==2)return k*k;
        
        if(memo.containsKey(n)){
            return memo.get(n);
        }
    
        memo.put(n,(k-1)*(totalWays(n-1,k) + totalWays(n-2, k)));
        return memo.get(n);
    }
    
}