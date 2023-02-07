class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (a[0]+ a[1]) - (b[0]+b[1])
        );

        for(int i = 0; i< nums1.length; i++){
            pq.add(new int[]{nums1[i],nums2[0],0}); //この3つめの引数が重要,,, これは解けなそう
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            int[] array = pq.poll();
            result.add(Arrays.asList(array[0],array[1]));

            int nums2Index = array[2]+1;
            if(nums2Index < nums2.length){
                pq.add(new int[]{array[0], nums2[nums2Index],nums2Index});
            }
        }
        return result;
    }
}