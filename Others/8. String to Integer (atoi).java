class Solution {
    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();
        //数字が来る前のスペースは除去する
        while(index<n && input.charAt(index) == ' '){
            index++;
        }
        // 符号を決める
        if(index<n && input.charAt(index) == '+'){
            sign = 1;
            index++;
        }else if(index<n && input.charAt(index) == '-'){
            sign = -1;
            index++;
        }

        //数字じゃない文字が来るまで横断していく
        while(index<n && Character.isDigit(input.charAt(index))){
            int digit = input.charAt(index) - '0'; // Charに'0'を引くとその数字になるらしい

            // オーバーフローチェック
            if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE /10 && digit > Integer.MAX_VALUE %10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = 10 * result + digit; //つねに1の位が足されるので元の数を10倍する
            index++;
        }

        return sign * result;


    }
}