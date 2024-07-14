class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[0]+a[1])-(b[0]+b[1])));
        int n2Index = 0;
        for(int num:nums1){
            pq.add(new int[]{num, nums2[0], n2Index});
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<k; i++){
            int[] val = pq.poll();
            result.add(Arrays.asList(val[0], val[1]));
            n2Index = val[2]+1;
            if(n2Index< nums2.length){
                pq.add(new int[]{val[0], nums2[n2Index], n2Index});
            }
        }
        return result;
        
    }
}