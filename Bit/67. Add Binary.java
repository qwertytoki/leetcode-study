class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length()-1;
        int bLen = b.length()-1;
        int over = 0;
        // aのほうが長いことが前提で進めるので、bが長い場合逆にする
        if(aLen < bLen){
            return addBinary(b,a);
        }
        StringBuilder sb = new StringBuilder();
        int j = bLen;
        for(int i = aLen; i >=0; i--, j--){
            if(a.charAt(i)== '1'){
                over++;
            }
            if(j>=0 && b.charAt(j)=='1'){
                over++;
            }
            if(over%2==1){
                sb.append("1");
            }else{
                sb.append("0");
            }
            over /= 2;
        }
        if(over==1){
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }
}