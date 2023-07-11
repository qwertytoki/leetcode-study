class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //重さでソートして、大きい順にピックしていく
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        int result = 0;
        for(int[] boxType : boxTypes){
            int size = Math.min(boxType[0], truckSize);
            result+=size*boxType[1];
            truckSize-=size;
            if(truckSize == 0){
                break;
            }
        }
        return result;
    }   
}

//time: O(NlogN)
//space:O(1)