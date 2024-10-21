class Solution {
    List<Integer> list;
    public int lengthOfLIS(int[] nums) {
        list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i<nums.length; i++){
            int num = nums[i];
            if(list.get(list.size()-1)<num){
                list.add(num);
            }else{
                int insertPoint = binarySearch(0, list.size()-1, num);
                list.set(insertPoint, num);
            }
        }
        return list.size();
    }

    private int binarySearch(int left, int right, int target){
        if(left>right){
            return left;
        }
        int mid = (left+right)/2;
        if(list.get(mid) == target){
            return mid;
        }
        if(list.get(mid)> target){
            return binarySearch(left, mid-1, target);
        }else{
            return binarySearch(mid+1, right, target);
        }
    }
}