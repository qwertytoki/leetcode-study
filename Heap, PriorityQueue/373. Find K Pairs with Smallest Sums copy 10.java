class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)->(a1[0]+a1[1]-(a2[0]+a2[1])));
        int nums2Index = 0;
        for(int num : nums1){
            pq.add(new int[]{num, nums2[0], nums2Index});
        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i =0; i<k;i++){
            int[] current = pq.poll();
            result.add(Arrays.asList(current[0], current[1]));
            nums2Index = current[2]+1;
            if(nums2Index < nums2.length){
                pq.add(new int[]{current[0],nums2[nums2Index], nums2Index});
            }
        }
        return result;
    }
}