class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+b[1]));
        for(int num:nums1){
            pq.add(new int[]{num,nums2[0],0}); // put the nums1&nums2[0] arrays to pq first.
            // put 0 to last index. 
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<k && !pq.isEmpty(); i++){
            // it does not use i value itself
            int[] current = pq.poll();
            result.add(Arrays.asList(current[0], current[1]));
            int index = current[2];
            if(index+1 < nums2.length){
                pq.add(new int[]{current[0], nums2[index+1], index+1});
            }
        }
        return result;

    }
}