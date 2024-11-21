class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;

        for(int i = 0; i<s.length(); i++){
            String roman = "";
            if(i!= s.length()-1){
                roman = ""+ s.charAt(i) + s.charAt(i+1);
                if(map.containsKey(roman)){
                    result += map.get(roman);
                    i++;
                    continue;
                }
            }
            roman = ""+ s.charAt(i);
            result += map.get(roman);
        }
        return result;
    }
}