class Solution {
    public int searchInsert(int[] nums, int target) {
        //バイナリサーチ：リストを半分にして、半分より上か、下かでさらに対象を絞っていく
        int startIndex = 0;
        int endIndex = nums.length-1;
        
        while(startIndex <= endIndex){ // ＝いれていいかは後で判断
            int middleIndex = (startIndex + endIndex)/2;
            if(nums[middleIndex] == target) return middleIndex;
            
            if(nums[middleIndex]> target){
                endIndex = middleIndex-1;
            }else{
                startIndex =  middleIndex +1;
            }
            
        }
        
        return startIndex;
    }
}