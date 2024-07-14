class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i =1; i< nums.length; i++){
            int num = nums[i];
            if(num>list.get(list.size()-1)){
                list.add(num);
            }else{
                list.set(insertPosition(list, num, 0, list.size()-1), num);
            }
        }
        return list.size();
    }

    private int insertPosition(List<Integer> list, int target, int left, int right){
        if(left>right){
            return left;
        }
        int mid = (left+right)/2;
        if(target== list.get(mid)){
            return mid;
        }
        if(target>list.get(mid)){
            return insertPosition(list, target, mid+1, right);
        }else{
            return insertPosition(list, target, left, mid-1);
        }
    }
}