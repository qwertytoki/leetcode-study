
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                if (i - map.get(num) <= k) {
                    return true;
                } else if (i - map.get(num) > k) {
                    map.put(num, i);
                }
            }
        }
        return false;
    }
}
