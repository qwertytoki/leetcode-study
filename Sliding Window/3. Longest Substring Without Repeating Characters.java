class Solution {
    public int lengthOfLongestSubstring(String s) {
        // iとjの差分が一番大きいところを取得する
        // mapを宣言し、同じkeyをみつけたらindexを更新する
        // jをスライドさせていき、mapに同じ数字があったらiを更新する
        // iとjの差を今の最大幅と比較する
        
        int length = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0, j=0; j<length;j++ ){ // for文内に変数2つ同時に宣言できるんだね
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            result = Math.max(result,j-i+1);
            map.put(s.charAt(j),j+1);
        }  
        
        return result;
    }
}