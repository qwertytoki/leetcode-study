class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> countMap = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            Character c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        for(int i = 0;i<n; i++){
            Character c = s.charAt(i);
            if(countMap.get(c)==1){
                return i;
            }
        }
        return -1;
    }
}