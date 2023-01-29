class Solution {
    public int firstUniqChar(String s) {
        //0 
        if(s.length() == 0) return -1;
        //1
        char[] sArray = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        //2 
        for(char c : sArray){
            //3
            map.put(c,map.getOrDefault(c,0) +1);
        }
        for(int i = 0; i<s.length();i++){
            if(map.get(sArray[i])==1){
                return i;
            }
        }
        return -1;
    }
}