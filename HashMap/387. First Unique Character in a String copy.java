'class Solution {
    public int firstUniqChar(String s) {
        // we want to retain the order of map, so use LinkedHashMap. 
        //0 corner case. 
        //1 s to charArray, create LinkedHashMap<Character, Integer>
        //2 for loop charArray
            //3 put character to map, if there is key already, value+1
        //4 for loop map
            //5 get first key of map whose value == 1
        //6 for loop charArray
            //7 return the key's index
        //8 return -1

        //0 
        if(s.length() == 0) return -1;
        //1
        char[] sArray = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        //2 
        for(char c : sArray){
            //3
            map.put(c,map.getOrDefault(c,0) +1);
        }
        //4
        char uKey = '-';
        for(Character c:map.keySet()){
            //5
            if(map.get(c)==1){
                uKey = c;
                break;
            }
        }
        //6
        for(int i = 0; i < sArray.length; i++){
           //7
            if(sArray[i]==uKey){
                return i; 
            }
        }
        
        //8
        return -1;

    }
}'