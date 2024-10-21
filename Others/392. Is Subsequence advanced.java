class Solution {
    // follow-up questionの、もしもtが十分に大きい数だった場合はどうするか？
    // に対する回答がこれ。 Mapを作成することでtへのアクセス回数を1回にしている。
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i< t.length(); i++){
            char tc = t.charAt(i);
            if(!map.containsKey(tc)){
                map.put(tc, new ArrayList<>());
            }
            map.get(tc).add(i);
        }
        int index = -1;
        for(int i = 0; i< s.length();i++){
            char sc = s.charAt(i);
            if(!map.containsKey(sc)){
                return false;
            }
            boolean isFind = false;
            for(int tIndex:map.get(sc)){
                if(tIndex>index){
                    index = tIndex;
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                return false;
            }
        }
        return true;
    }
}