class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        return str1.substring(0,calcGcd(str1.length(), str2.length()));
    }

    private int calcGcd(int i1, int i2){
        if(i2 == 0){
            return i1;
        }
        return calcGcd(i2, i1%i2);
    }
}