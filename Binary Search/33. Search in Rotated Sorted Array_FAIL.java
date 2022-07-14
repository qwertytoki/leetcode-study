class Solution {
    public int search(int[] nums, int target) {
        // rotatedなので、区切りがわからない。
        // startとendの値、実際に取れた値 の3つを比較して検討する
        
        
        if(nums == null) return -1;
        
        int startIdx = 0;
        int endIdx = nums.length-1;
        int startVal = nums[0]; // safe, nums.length>1 
        int endVal = nums[nums.length-1];
        
        while(startIdx<= endIdx){
            int midIdx = (startIdx + endIdx)/2;
            int midVal = nums[midIdx];
            
            if(target == midVal){
                return midIdx;    
            }
            if(midVal>startVal){
                if(target < midIdx && target>=startVal){
                    endIdx = midIdx -1;
                }else{
                    startIdx = midIdx +1;
                }   
            }else{
                if(target > midIdx && target<=endVal){
                    startIdx = midIdx +1;
                }else{
                    endIdx = midIdx -1;
                }    
            }
            
        }
        
        return -1;
    }
}
