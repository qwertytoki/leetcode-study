class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //PriorityQueueに先に片方を全部入れてから、反対側と比較していく
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> (a[0]+a[1]) - (b[0]+b[1])
        );
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0){
            return result;
        }
        for(int num:nums1){
            pq.add(new int[]{num, nums2[0], 0}); // 3rd arg is for num2's index.
        }
        for(int i = 0;i<k && !pq.isEmpty(); i++){
            int[] current = pq.poll();
            result.add(Arrays.asList(current[0], current[1]));
            int index = current[2]+1;
            if(index<nums2.length){
                pq.add(new int[]{current[0], nums2[index], index});
            }
            
        }
        return result;
    }
}