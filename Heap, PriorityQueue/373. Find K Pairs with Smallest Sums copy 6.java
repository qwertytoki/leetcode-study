class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[0]+a[1])-(b[0]+b[1])));
        for(int num:nums1){
            pq.add(new int[]{num,nums2[0],0});
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<k; i++){
            int[] current = pq.poll();
            int num2Index = current[2];
            result.add(Arrays.asList(current[0], current[1]));
            if(num2Index < nums2.length-1){
                num2Index++;
                pq.add(new int[]{current[0], nums2[num2Index],num2Index});
            }
        }
        return result;
    }
}