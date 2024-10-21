class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        int size = s.length();
        while(index < size && s.charAt(index)==' '){
            index++;
        }
        if(index < size && s.charAt(index) == '+'){
            index++;
            sign = 1;
        }else if(index < size && s.charAt(index) == '-'){
            index++;
            sign = -1;
        }
        
        while(index < size && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result *10 + digit;
            index++;
        }
        

        return sign * result;
    }
}