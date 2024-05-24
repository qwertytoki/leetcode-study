class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int nums2Idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+ b[1]));
        for(int num : nums1){
            pq.add(new int[]{num, nums2[0], nums2Idx});
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0 ; i< k; i++){
            int[] current = pq.poll();
            result.add(Arrays.asList(current[0], current[1]));
            nums2Idx = current[2]+1;
            if(nums2Idx< nums2.length){
                pq.add(new int[]{current[0], nums2[nums2Idx], nums2Idx});
            }
        }
        return result;
    }
}