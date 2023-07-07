class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static{
        map.put("I",1);
        map.put("V",5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV",4);
        map.put("IX",9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);    
    }
        
    public int romanToInt(String s) {
        String lastS = s.substring(s.length()-1);
        int lastVal = map.get(lastS);
        int total = lastVal;
        for(int i = s.length() -2; i >= 0; i-- ){
            String currentS = s.substring(i, i+1);
            int currentVal = map.get(currentS);
            if(currentVal < lastVal){
                total -= currentVal;
            } else{
                total+= currentVal;
            }
            lastVal = currentVal;
        }
        return total;

    }
}