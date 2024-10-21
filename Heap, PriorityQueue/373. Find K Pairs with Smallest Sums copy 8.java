class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]+a[1]) - (b[0]+b[1]));
        for(int num: nums1){
            pq.add(new int[]{num, nums2[0],0}); // 3つめのindexは、いまnum2の何番目を使っているかを表している
        }
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i<k; i++){
            if(pq.isEmpty()) break;
            int[] current = pq.poll();
            result.add(Arrays.asList(current[0],current[1]));
            int index = current[2] +1;
            if(index < nums2.length){ //nums2[]num2の何番目+1]が存在するなら、それをpqに追加している。 なければいまpqに入ってるものが答え
                pq.add(new int[]{current[0], nums2[index] ,index});
            }
        }

        return result;
    }
}