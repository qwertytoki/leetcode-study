class Solution {
    public int lengthOfLIS(int[] nums) {
        // gererate sorted list. 
        // find and replace if previous one is bigger
        // just add to the list if the item is bigger than previous

        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);
        for(int i=1;i<nums.length; i++){
            if(result.get(result.size()-1)< nums[i]){
                result.add(nums[i]);  
            }else{
                int insertPoint = findInsertPoint(result, nums[i]);
                result.set(insertPoint, nums[i]);
            }
        }
        return result.size();
    }

    private int findInsertPoint(List<Integer> list, int value){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int mid = (left+right)/2;
            if(list.get(mid) == value ){
                return mid;
            }
            if(list.get(mid) < value){
                left = mid +1;
            }else{
                right = mid;
                //ここでは、完全一致ではなく、最小の値探しだから、 -1にしない。
            }
        }
        return left;
    }
}