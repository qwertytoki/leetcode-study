class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int index = 0;
        int result = 0;
        int length = s.length();
        
        while(index < length && s.charAt(index) == ' '){
            index++;
        }
        if(index<length && s.charAt(index) == '+'){
            sign = 1;
            index++;
        }
        else if(index<length && s.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        while(index<length && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if(result > Integer.MAX_VALUE /10 || result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result *10 + digit;
            index++;
        }
        return sign*result;
    }
}