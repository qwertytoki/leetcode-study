69. Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        //バイナリサーチ 
        // xの平方根は2よりも大きくx/2よりも小さいことを利用してwhile回す
        if(x <2) return x;
        long num;
        int pivot, left = 2, right = x/2;
        while(left<=right){
            pivot = left + (right - left) /2; //典型的なバイナリサーチ
            num = (long) pivot*pivot;
            if(num > x) right = pivot -1;
            else if(num<x) left = pivot +1;
            else return pivot; // 一致したらそのまま返す
        }
        return right;
    }
}