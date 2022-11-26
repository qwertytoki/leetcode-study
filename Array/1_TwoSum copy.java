

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //重複でないように1回のfor文で仕留める
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}