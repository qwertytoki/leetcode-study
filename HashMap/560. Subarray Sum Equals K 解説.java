class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
        やり方はTwoSumと似ている
        mapのkeyにはいままでのsumを詰めておく
        sum-k =key (-> sum-key = k)となる点をさがす。あった場合、countを更新
        keyは何度か同じ値を通ることがあるので、重複回数分追加する
         */
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0; i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}