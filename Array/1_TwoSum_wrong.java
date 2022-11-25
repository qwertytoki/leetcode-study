class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMapかな。マイナスした値をkeyに入れるイメージ O(N)
        int[] result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numsMap.put(target-nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(numsMap.containsKey(nums[i])){
                result[0] = i;
                result[1] = numsMap.get(nums[i]);
                return result;
            }   
        }
        return null;
    }
}