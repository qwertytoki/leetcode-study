class Solution {
    List<Integer> sortedList;

    public int lengthOfLIS(int[] nums) {
        sortedList = new ArrayList<>();
        sortedList.add(nums[0]);
        for(int i = 1; i< nums.length; i++){
            if(sortedList.get(sortedList.size()-1) < nums[i]){
                sortedList.add(nums[i]);
            }else{
                int insertPoint = findInsertPoint(0, sortedList.size()-1, nums[i]);
                sortedList.set(insertPoint, nums[i]);
            }
        }    
        return sortedList.size();
    }

    private int findInsertPoint(int left, int right, int target){
        if(left> right){
            return left;
        }
        int mid = (left-right)/2 + right;
        if(sortedList.get(mid) == target){
            return mid;
        }
        if(sortedList.get(mid)<target){
            return findInsertPoint(mid+1, right, target);
        }else{
            return findInsertPoint(left, mid-1, target);
        }
    }
}