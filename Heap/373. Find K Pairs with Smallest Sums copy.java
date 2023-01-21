class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // 1 declear priorityQueue for int[]
        // 2 put the int[] which has all nums1 value and nums2[0], and index value for 3(this is important in next loop)
        // loop k {
        //   3 poll and put the int[] to result, and add nums1 val and nums2 val
        // }
        // 4 return result
        // いやーこれ解法覚えてないとしんどいなーしかし

        // 1
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]+a[1]) - (b[0]+b[1]));
        // 2
        for(int i=0; i<nums1.length; i++){
            pq.add(new int[]{nums1[i],nums2[0],0});
        }
        List<List<Integer>> result = new ArrayList<>();
        // 3
        for(int i=0; i<k && !pq.isEmpty();i++){
            int[] minArray = pq.poll();
            result.add(Arrays.asList(minArray[0], minArray[1]));

            int num2Index = minArray[2];
            if(num2Index < nums2.length -1){
                pq.add(new int[]{minArray[0],nums2[num2Index +1],num2Index+1});
            }

        }
        // 4
        return result;
    }
}