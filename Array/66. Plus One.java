class Solution {
    public int[] plusOne(int[] digits) {
        //9なら0にして次の桁を1繰り上げる
        //すべて9なら1を足す -> これ重要
        
        int n = digits.length;
        for(int i= n-1; i>=0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        
        // ここに来たらすべて9だったということ
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}