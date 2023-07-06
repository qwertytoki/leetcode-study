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
        int sum = 0;
        int i = 0;
        while(i < s.length()){
            String currentS = s.substring(i,i+1);
            int currentVal = map.get(currentS);
            int nextVal = 0;
            if(i+1 < s.length()){
                String nextS = s.substring(i+1,i+2);
                nextVal = map.get(nextS);
            }
            if(currentVal<nextVal){
                sum += (nextVal - currentVal);
                i+=2;
            }else{
                sum += currentVal;
                i+=1;
            }
        }
        return sum;
    }
}
