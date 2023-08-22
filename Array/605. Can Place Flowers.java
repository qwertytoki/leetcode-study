class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i<flowerbed.length;i++){
            if(flowerbed[i] == 1){
                continue;
            }
            boolean leftEmpty = i == 0 || flowerbed[i-1]==0;
            boolean rightEmpty = i == flowerbed.length-1 || flowerbed[i+1] ==0;
            if(leftEmpty && rightEmpty){
                count++;
                flowerbed[i] = 1;
            }
        }
        return count>= n;
    }
}