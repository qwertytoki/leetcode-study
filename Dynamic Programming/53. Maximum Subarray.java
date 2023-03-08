class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        List<Integer> sub = new ArrayList<>();
        int current = 0;
        for(int i : nums){
            current = current + i;
            if(current <0){
                sub = new ArrayList<>();
                max = Math.max(current,max);
                current = 0;
                continue;
            }
            sub.add(i);
            max = Math.max(current,max);
        }
        return max;
    }
}