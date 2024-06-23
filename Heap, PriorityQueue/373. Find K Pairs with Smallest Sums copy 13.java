class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[0]+a[1])-(b[0]+b[1])));
        for(int num: nums1){
            pq.add(new int[]{num, nums2[0],0});
        }
        for(int i = 0; i<k; i++){
            int[] arr = pq.poll();
            int nums2Index = arr[2];
            result.add(Arrays.asList(arr[0], arr[1]));
            nums2Index++;
            if(nums2Index<nums2.length){
                pq.add(new int[]{arr[0], nums2[nums2Index], nums2Index});
            }
        }
        return result;
    }
}