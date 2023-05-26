class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 左を先に入れて、その後、次のやつと右を比べていく
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0){
            return result;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> (a[0]+a[1]) - (b[0]+b[1]));
        for(int num:nums1){
            pq.add(new int[]{num,nums2[0],0});
        }
        for(int i = 0; i<k && !pq.isEmpty(); i++){
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

// time: min(O(klogk), O(nums1*nums2 log(nums1*nums2)))
// space: min(O(k), O(nums1*nums2))