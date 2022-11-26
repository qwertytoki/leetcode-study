class Solution {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }   
    
    public int romanToInt(String s) {
        //すべての文字をマップに入れる
        //2文字から順に調べる(4,9のチェックのため)
        int result = 0;
        for(int i = 0; i< s.length(); i++){
            String roman = "";
            if(i+1<s.length()){
                roman= s.substring(i,i+2);
                if(values.containsKey(roman)){
                    i++;
                    result+=values.get(roman);
                    continue;
                }    
            }    
            roman = s.substring(i,i+1);
            if(values.containsKey(roman)){
                result += values.get(roman);   
            }
        }
        return result;
        
    }
}